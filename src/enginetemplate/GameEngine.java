/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate;

import enginetemplate.room.*;
import enginetemplate.utility.Drawing;
import enginetemplate.utility.GameMouseListener;
import enginetemplate.utility.Globals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameEngine extends JFrame {
    // *** Action listeners ***
    private class GameLogicUpdateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Globals.getInstance().elapsedSteps++;
            room.update();
        }
    }
    
    private class DrawingUpdateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Drawing.getInstance().repaint();
        }
    }
    
    // *** Singleton ***
    private static GameEngine instance = null;

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    Room room;
    GameMouseListener mouseListener;
    Timer gameLogicTimer;
    Timer drawingTimer;
    int fps;
    
    private GameEngine() {
        // Init timer
        gameLogicTimer = new Timer(100, new GameLogicUpdateActionListener());
        gameLogicTimer.start();
        drawingTimer = new Timer(100, new DrawingUpdateActionListener());
        drawingTimer.start();
        
        // Init UI
        add(Drawing.getInstance());
        setTitle("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Init mouse
        mouseListener = new GameMouseListener();
        Drawing.getInstance().addMouseListener(mouseListener);
        
        // Go to the first room
        goToRoom(new StartRoom());
        setVisible(true);
    }
    
    // *** Functions ***
    public final void goToRoom(Room r) {
        // End the current room
        if (this.room!=null) {
            this.room.end();
        }
        
        this.room = r;
        
        Drawing.getInstance().setRoom(room);
        mouseListener.setRoom(room);
        setSize(room.width, room.height);
        fps = room.speed;
        gameLogicTimer.setDelay(1000/room.speed);
        gameLogicTimer.restart();
        gameLogicTimer.setDelay(1000/fps);
        drawingTimer.setInitialDelay(2);
        drawingTimer.restart();
        
        this.room.start();
    }
}
