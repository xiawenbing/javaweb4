package Vo;

public class User {
    private static String userName;
    private static String chrName;
    private static String password;
    private static String  role;

    public User() {
        super();
    }

    public User(String userName, String password, String chrName, String role) {
        super();
        this.userName = userName;
        this.password = password;
        this.chrName = chrName;
        this.role = role;
    }

    public static String getUserName() {
        return userName;
    }

    public  void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getChrName() {
        return chrName;
    }

    public void setChrName(String chrName) {
        this.chrName = chrName;
    }

    public static String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public static String getRole() {
        return role;
    }

    public  void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "userName=" + userName + ", password=" + password + ", chrName=" + chrName + ", role=" + role;
    }
}
