/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.gameobject;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Button extends GameObject {
    public String text = "";
    public Color color = Color.green;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        this.bboxWidth = 200;
        this.bboxHeight = 50;
    };
    
    @Override
    public void onDraw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.fillRect((int) x, (int) y, (int) bboxWidth, (int) bboxHeight);
        g2d.setColor(Color.black);
        g2d.drawRect((int) x, (int) y, (int) bboxWidth, (int) bboxHeight);
        
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 32)); 
        
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(text, g2d);
        int xx = (int) (x + (this.bboxWidth - r.getWidth()) / 2);
        int yy = (int) (y + (this.bboxHeight - r.getHeight()) / 2 + fm.getAscent());
        g2d.drawString(text, xx, yy);
    }
}
