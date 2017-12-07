/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.room.utility;

import enginetemplate.gameobject.GameObject;
import enginetemplate.room.Room;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TransformInstancesList {

    final Room room;
    Map<Long, GameObject> instances;
    List<GameObject> instancesByDepth;

    public TransformInstancesList(Room room) {
        this.room = room;
        instancesByDepth = new ArrayList<>();
    }

    public void update() {
        instances = this.room.getAllInstances();
        instancesByDepth = updateInstancesByDepth();
    }

    public List<GameObject> getInstancesByDepth() {
        return instancesByDepth;
    }

    private List<GameObject> updateInstancesByDepth() {
        // Comparators to compare GameObjects by depth
        Comparator<GameObject> depthComparator = new Comparator<GameObject>() {
            public int compare(GameObject a, GameObject b) {
                Integer depthA = a.depth;
                Integer depthB = b.depth;
                return depthA.compareTo(depthB);
            }
        };

        // Load the GameObjects to array list
        ArrayList<GameObject> objects = new ArrayList<>();
        for (GameObject obj : instances.values()) {
            objects.add(obj);
        }

        // Sort
        objects.sort(depthComparator);

        return objects;
    }
}
