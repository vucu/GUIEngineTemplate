/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enginetemplate.gameobject;

import enginetemplate.utility.Drawing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public abstract class TextField extends GameObject {
    private class ConfirmActionListener implements ActionListener {
        TextField textField;
        
        public ConfirmActionListener(TextField textField) {
            this.textField = textField;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            this.textField.onConfirm();
        }
    }
    
    protected JTextField jTextField;
    
    public TextField() {
        this.jTextField = new JTextField();
        this.jTextField.addActionListener(new ConfirmActionListener(this));
    }
    
    // *** Events ***
    public void onConfirm() {};
    
    @Override
    public void onRoomStart() {
        super.onRoomStart();
        Drawing.getInstance().add(jTextField);
    }
    
    @Override
    public void onRoomEnd() {
        super.onRoomEnd();
        Drawing.getInstance().remove(jTextField);
    }
    
    // *** Functions ***
    public final JTextField getJTextFieldComponent() {
        return jTextField;
    }
}
