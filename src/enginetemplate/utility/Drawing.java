/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.utility;

import enginetemplate.gameobject.GameObject;
import enginetemplate.room.Room;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JPanel;

public class Drawing extends JPanel {
    private static Drawing instance = null;
    private Room room;
    
    private Drawing() {
    }

    public static Drawing getInstance() {
        if (instance == null) {
            instance = new Drawing();
        }
        return instance;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        List<GameObject> instances = room.transformInstancesList.getInstancesByDepth();
        for (GameObject obj:instances) {
            obj.onDraw(g);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }  
}