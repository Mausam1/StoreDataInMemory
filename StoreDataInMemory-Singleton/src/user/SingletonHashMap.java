/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.HashMap;
import java.util.Map;

public class SingletonHashMap extends HashMap {
   //  Create private singleton object of SingletonHashMap class
    private static SingletonHashMap singleton;
 
    // Create new final map
   final private Map<String, User> usermap;

   //Create new private method which create new HashMap
    private SingletonHashMap() {
        usermap = new HashMap<String, User>();
    }

    //Create getter method for SingletonHashMap class
    public static SingletonHashMap getInstance() {
        //Create condition to checks singleton object is null or not
        if (singleton == null) {
            singleton = new SingletonHashMap();
        }
        return singleton;
    }

}
