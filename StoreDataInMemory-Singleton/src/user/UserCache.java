/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import static user.UserClient.Start;
import static user.UserCache.Usermap;
import java.util.HashMap;
import java.util.Map;

public class UserCache {
    //Create new singletonhashmap object
    public static Map<String, User> Usermap = SingletonHashMap.getInstance();

    //Create method to save users
    public void Save(String[] splited) {
        //Create condition to check entered username is already exist in cache or not
        if (!CheckUserExistornot(splited[1].split(",")[0], (HashMap<String, User>) Usermap)) {
            System.out.println("Entered user already exist \n");
            //Call start method to give chance to enter input again
            Start();
        }
        //Create new user to store new user data
        User user = new User();

        user.setUsername(splited[1].split(",")[0]);
        user.setFirstName(splited[1].split(",")[1]);
        user.setLastName(splited[1].split(",")[2]);
        user.setEmailAddress(splited[1].split(",")[3]);
        //store user object and out primary key username into our HashMap
        Usermap.put(user.getUsername(), user);
        System.out.println(""+user.getUsername()+" has been saved \n");
        // System.out.println("uname : "+ user.getUsername()+ " fname : "+ user.getFirstName()+ " lname : " + user.getLastName()+ " email : "+ user.getEmailAddress());
        Start();
    }

    //Create method to find all stored users
    public void Findall(String[] splited) {
        //Create a for loop to find all the stored user object from HashMap
        for (Object userobj : Usermap.values()) {
            User usertmp = (User) userobj;
            System.out.println("User: " + usertmp.getUsername() + ", " + usertmp.getFirstName() + ", " + usertmp.getLastName() + ", " + usertmp.getEmailAddress());
        }
        //Create condition, if our HashMap is empty that system doesn't have any user to display
        if (Usermap.isEmpty()) {
            System.out.println("No user exist");
        }
        System.out.print("\n");
        Start();

    }

    //Create method to find all users
    public void Find(String[] splited) {
        //Create a for loop to find user object according to entered username
        for (Object str : Usermap.keySet()) {
            //Create condition to check entered username is in hashmap or not
            if (str.equals(splited[1])) {
                User usertmp = Usermap.get(str);
                System.out.println("User: " + usertmp.getUsername() + ", " + usertmp.getFirstName() + ", " + usertmp.getLastName() + ", " + usertmp.getEmailAddress()+" \n");
                Start();
                break;
            }
        }
        // If entered username is not in HashMap then it shows below message
        System.out.println(""+splited[1]+" does not exist \n");
        Start();
    }

    //Create method to update details of user
    public void Update(String[] splited) {
        //Create for loop to find stored user object according to entered username from hashmap
        for (Object str : Usermap.keySet()) {
            //Create condition to check entred username is in hashmap or not and if its in hashmap then old entered values replace by new values 
            if (str.equals(splited[1].split(",")[0])) {
                User usertmp = Usermap.get(str);
                usertmp.setFirstName(splited[1].split(",")[1]);
                usertmp.setLastName(splited[1].split(",")[2]);
                usertmp.setEmailAddress(splited[1].split(",")[3]);
                System.out.println((splited[1].split(",")[0])+" updated \n");
                Start();
                break;
            }
        }
        //If entered username is not in hashmap then it shows below message 
        System.out.println((splited[1].split(",")[0])+" does not exist \n");
        Start();
    }

    //Create method to delete user
    public void Delete(String[] splited) {
        //Create for loop to find stored user object according to entered username from hashma
        for (Object str : Usermap.keySet()) {
         //Create condition to check entred username is in hashmap or not and if its in hashmap then delete it 
            if (str.equals(splited[1])) {
                Usermap.remove(str);
                System.out.println(splited[1]+" deleted \n");
                Start();
                break;
            }
        }
        //If entered username is not in hashmap then it shows below message 
        System.out.println(splited[1]+" does not exist \n");
        Start();
    }

    //Create method to check user exist or not in hashmap
    public boolean CheckUserExistornot(String username, HashMap<String, User> usermap) {
        for (Object str : usermap.keySet()) {
            if (str.equals(username)) {
                return false;
                //System.out.println("username: " + Usermap.get(str).getUsername() + ", firstname: " + Usermap.get(str).getFirstName() + ", lastname: " + Usermap.get(str).getLastName() + ", emailid: " + Usermap.get(str).getEmailAddress());
            }
        }
        return true;
    }

}
