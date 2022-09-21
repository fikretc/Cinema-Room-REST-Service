package cinema;

public class UserCredentials {
    String password;
    UserCredentials() {}
    UserCredentials(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
