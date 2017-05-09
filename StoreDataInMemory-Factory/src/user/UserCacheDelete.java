package user;

import static user.UserClient.Start; 

public class UserCacheDelete extends UserCache {

    @Override
    public void ExecuteCommand(String[] splited) {
        //Create for loop to find stored user object according to entered username from hashma
        for (Object str : Usermap.keySet()) {
            //Create condition to check entred username is in hashmap or not and if its in hashmap then delete it 
            if (str.equals(splited[1])) {
                Usermap.remove(str);
                System.out.println(splited[1] + " deleted \n");
                Start();
                break;
            }
        }
        //If entered username is not in hashmap then it shows below message 
        System.out.println(splited[1] + " does not exist \n");
        super.ExecuteCommand(splited); //To change body of generated methods, choose Tools | Templates.
    }

}
