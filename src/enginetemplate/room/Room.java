/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.room;

import enginetemplate.gameobject.GameObject;
import enginetemplate.room.utility.TransformInstancesList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Room {
    Map<Long,GameObject> instances;
    public final TransformInstancesList transformInstancesList;
    
    // *** Properties ***
    public int width;
    public int height;
    public int speed;
    
    public Room() {
        instances = new ConcurrentHashMap<>();
        transformInstancesList = new TransformInstancesList(this);
    }
    
    // *** Functions ***
    public final GameObject createInstance(final double x, final double y, GameObject obj) {
        obj.x = x;
        obj.y = y;
        obj.setRoom(this);
        obj.onCreate();
        
        instances.put(obj.id, obj);
        return obj;
    }
    
    public final void removeInstance(final long id) {
        GameObject obj = instances.get(id);
        if (obj!=null) {
            obj.onDestroy();
            instances.remove(id);
        }
    }
    
    public final GameObject getInstance(final long id) {
        return instances.get(id);
    }
    
    public final List<GameObject> getInstanceByType(Class c) {
        List<GameObject> result = new ArrayList<>();
        
        for (GameObject obj:instances.values()) {
            if (c.isInstance(obj)) {
                result.add(obj);
            }
        }
        
        return result;
    }
    
    public final boolean instanceExists(Class c) {
        List<GameObject> list = getInstanceByType(c);
        return (!list.isEmpty());
    }
    
    public final Map<Long,GameObject> getAllInstances() {
        return instances;
    }
    
    // *** Events ***
    public final void start() {
        // Update objects
        for (GameObject obj:instances.values()) {
            obj.onRoomStart();
        }
    }
    
    public final void end() {
        for (GameObject obj:instances.values()) {
            obj.onRoomEnd();
        }
    }
    
    public final void update() {
        // Update secondary objects
        transformInstancesList.update();

        // Update objects
        for (GameObject obj:instances.values()) {
            obj.onStepUpdateBegin();
        }
        
        for (GameObject obj:instances.values()) {
            obj.onStepUpdate();
        }
        
        for (GameObject obj:instances.values()) {
            obj.onStepUpdateEnd();
        }
    }
}