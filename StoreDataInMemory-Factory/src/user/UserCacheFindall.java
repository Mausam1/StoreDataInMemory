package user;

public class UserCacheFindall extends UserCache {

    @Override
    public void ExecuteCommand(String[] splited) {
        //Create a for loop to find all the stored user object from HashMap
        for (Object userobj : Usermap.values()) {
            User usertmp = (User) userobj;
            System.out.println("User: " + usertmp.getUsername() + ", " + usertmp.getFirstName() + ", " + usertmp.getLastName() + ", " + usertmp.getEmailAddress());
        }
        //Create condition, if our HashMap is empty that system doesn't have any user to display
        if (Usermap.size() == 0) {
            System.out.println("No user exist");
        }
        System.out.print("\n");

        super.ExecuteCommand(splited); //To change body of generated methods, choose Tools | Templates.
    }

}
