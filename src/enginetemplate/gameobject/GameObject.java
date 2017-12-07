/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.gameobject;

import enginetemplate.room.Room;
import enginetemplate.utility.GenerateUniqueId;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class GameObject {
    protected Room room;
    
    // *** Properties ***
    public double x;
    public double y;
    public int depth;
    public final long id;
    
    public boolean maskIndex;
    public double bboxWidth;
    public double bboxHeight;
    
    public GameObject() {
        id = GenerateUniqueId.getInstance().generateUniqueId();
        depth = 0;
        maskIndex = false;
    }
    
    // *** Events ***
    public void onCreate() {};
    public void onDestroy() {};
    public void onStepUpdateBegin() {};
    public void onStepUpdate() {};
    public void onStepUpdateEnd() {};
    public void onRoomStart() {};
    public void onRoomEnd() {}
    public void onDraw(Graphics g) {};
    public void onClick() {};
     
    // *** Functions ***
    public final void setRoom(Room r) {
        this.room = r;
    } 
    
    public final void instanceDestroy() {
        this.room.removeInstance(id);
    }
}