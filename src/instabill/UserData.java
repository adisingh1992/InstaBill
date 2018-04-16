package instabill;

/**
 * @author scorpion
 */
public class UserData {

    private static UserData userdata;
    private static String username;
    private static String password;

    private UserData() {
    }

    public static UserData getInstance() {
        if (userdata == null) {
            userdata = new UserData();
        }
        return userdata;
    }

    public String getUserName() {
        return UserData.username;
    }

    public void setUserData(String username, String password) {
        UserData.username = username;
        UserData.password = password;
    }
}