package user;

import static user.UserClient.Start; 


public class UserCacheUpdate extends UserCache {

    @Override
    public void ExecuteCommand(String[] splited) {
        //Create for loop to find stored user object according to entered username from hashmap
        for (Object str : Usermap.keySet()) {
            //Create condition to check entred username is in hashmap or not and if its in hashmap then old entered values replace by new values 
            if (str.equals(splited[1].split(",")[0])) {
                User usertmp = (User) Usermap.get(str);
                usertmp.setFirstName(splited[1].split(",")[1]);
                usertmp.setLastName(splited[1].split(",")[2]);
                usertmp.setEmailAddress(splited[1].split(",")[3]);
//              System.out.println("username: " + usertmp.getUsername() + ", firstname: " + usertmp.getFirstName() + ", lastname: " + usertmp.getLastName() + ", emailid: " + usertmp.getEmailAddress());
                System.out.println((splited[1].split(",")[0]) + " updated \n");
                Start();
                break;
            }
        }
        //If entered username is not in hashmap then it shows below message 
        System.out.println((splited[1].split(",")[0]) + " does not exist \n");
        super.ExecuteCommand(splited); //To change body of generated methods, choose Tools | Templates.
    }

}

