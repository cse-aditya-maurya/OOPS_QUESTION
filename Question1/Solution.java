public class Solution {

    public static void main(String[] args) {

        UserSession s1 = new UserSession(1, "Admin");
        UserSession s2 = new UserSession(2, "Developer");

        s1.display();
        s2.display();

        System.out.println("Total Sessions: " + UserSession.getTotalSessions());
    }
}

class UserSession {

    private int userId;
    private String userName;
    private static int totalSessions = 0;

    static {
        System.out.println("Session System Initialized");
    }

    {
        System.out.println("New Session Object Created");
    }

    public UserSession(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        totalSessions++;
    }

    public void display() {
        System.out.println(userId + " " + userName);
    }

    public static int getTotalSessions() {
        return totalSessions;
    }
}