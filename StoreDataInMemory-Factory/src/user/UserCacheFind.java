package user;

import static user.UserClient.Start; 


public class UserCacheFind extends UserCache {

    @Override
    public void ExecuteCommand(String[] splited) {
        //Create a for loop to find user object according to entered username
        for (Object str : Usermap.keySet()) {
            //Create condition to check entered username is in hashmap or not
            if (str.equals(splited[1])) {
                User usertmp = (User) Usermap.get(str);
                System.out.println("User: " + usertmp.getUsername() + ", " + usertmp.getFirstName() + ", " + usertmp.getLastName() + ", " + usertmp.getEmailAddress() + " \n");
                Start();
            }
        }
        // If entered username is not in HashMap then it shows below message
        System.out.println("" + splited[1] + " does not exist \n");
        super.ExecuteCommand(splited); //To change body of generated methods, choose Tools | Templates.
    }

}

