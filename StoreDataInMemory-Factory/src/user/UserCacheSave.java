package user;

import static user.UserClient.Start;

import java.util.HashMap; 


public class UserCacheSave extends UserCache {

    @Override
    public void ExecuteCommand(String[] splited) {
        //Create condition to check entered username is already exist in cache or not
        if (!CheckUserExistornot(splited[1].split(",")[0], (HashMap<String, User>) Usermap)) {
            System.out.println("Entered user already exist \n");
            //Call start method to give chance to enter input again
            Start();
        }
        //Create new user to store new user data
        user = new User();
        user.setUsername(splited[1].split(",")[0]);
        user.setFirstName(splited[1].split(",")[1]);
        user.setLastName(splited[1].split(",")[2]);
        user.setEmailAddress(splited[1].split(",")[3]);
        //store user object and out primary key username into our HashMap
        Usermap.put(user.getUsername(), user);
        System.out.println("" + user.getUsername() + " has been saved \n");
        super.ExecuteCommand(splited); //To change body of generated methods, choose Tools | Templates.

    }

}

