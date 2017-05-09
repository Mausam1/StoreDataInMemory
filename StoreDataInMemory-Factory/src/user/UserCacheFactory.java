package user;

public class UserCacheFactory {

    public UserCache getCommand(String[] splited) {
        if (splited[0].equalsIgnoreCase("save")) {
            return new UserCacheSave();
        }
       else if (splited[0].equalsIgnoreCase("findall")) {
            return new UserCacheFindall();
        }
        else if (splited[0].equalsIgnoreCase("find")) {
            return new UserCacheFind();
        }
        else if (splited[0].equalsIgnoreCase("update")) {
            return new UserCacheUpdate();
        }
        else if (splited[0].equalsIgnoreCase("delete")) {
            return new UserCacheDelete();
        }
        
        return null;
    }
}
