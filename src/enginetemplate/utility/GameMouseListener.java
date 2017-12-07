/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.utility;

import enginetemplate.gameobject.GameObject;
import enginetemplate.room.Room;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GameMouseListener implements MouseListener {
    Room room;

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        List<GameObject> instances = room.transformInstancesList.getInstancesByDepth();
        for (GameObject obj : instances) {
            if (x > obj.x && x < obj.x+obj.bboxWidth
                    && y > obj.y && y < obj.y+obj.bboxHeight) {
                obj.onClick();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
