/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetemplate.utility;

public class GenerateUniqueId {
    private static GenerateUniqueId instance = null;
    private long currentId;
    
    private GenerateUniqueId() {
        currentId = 0;
    }

    public static GenerateUniqueId getInstance() {
        if (instance == null) {
            instance = new GenerateUniqueId();
        }
        return instance;
    }
    
    public long generateUniqueId() {
        currentId++;
        return currentId;
    }
}
