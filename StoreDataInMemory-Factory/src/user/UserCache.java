package user;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    //Create new user object
    public static User user;
    //Create new HashMap to store data
    public static Map<String, User> Usermap = new HashMap<String, User>();

    
    public void ExecuteCommand(String[] splited) {

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
