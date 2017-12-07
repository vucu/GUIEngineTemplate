/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.utility;

public class Globals {
    private static Globals instance = null;
    
    private Globals() {
    }

    public static Globals getInstance() {
        if (instance == null) {
            instance = new Globals();
        }
        return instance;
    }

    // *** Properties
    // Number of steps since the game start
    public long elapsedSteps = 0;
     
}
