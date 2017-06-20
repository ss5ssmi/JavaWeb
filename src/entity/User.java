package entity;

public class User {
    private static String userNo;
    private static String userPassword;
    private static String userType;
    private static String userName;
    private static String Sex;
    private static int Age;
    private static String Phone;
    private static String Add;


    public User(String userNo, String userPassword, String userType) {
        this.userNo = userNo;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public User() {
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getSex() {
        return Sex;
    }

    public static void setSex(String sex) {
        Sex = sex;
    }

    public static int getAge() {
        return Age;
    }

    public static void setAge(int age) {
        Age = age;
    }

    public static String getPhone() {
        return Phone;
    }

    public static void setPhone(String phone) {
        Phone = phone;
    }

    public static String getAdd() {
        return Add;
    }

    public static void setAdd(String add) {
        Add = add;
    }
}
