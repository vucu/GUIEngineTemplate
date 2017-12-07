/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enginetemplate.gameobject;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class FloatingText extends GameObject {
    public String text;
    public int lifetime;
    public int yspeed;
    
    private int tick;
    
    @Override
    public void onCreate() {
        tick = 0;
        yspeed = 5;
    }
    
    @Override
    public void onStepUpdate() {
        // Floating down
        y+=yspeed;
        
        // Self-destruct after lifetime expired
        tick++;
        if (tick>lifetime) {
            this.instanceDestroy();
        }
    }
    
    @Override
    public void onDraw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
        g2d.drawString(this.text,(int)(x),(int)(y));
    }
}
