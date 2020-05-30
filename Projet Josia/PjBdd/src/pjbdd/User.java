package pjbdd;

public class User {
    private String mail;
    private int password;
    private String type;

    public User(String mail, int password, String type) {
        this.mail = mail;
        this.password = password;
        this.type= type;
    }

    public String getMail() {
        return mail;
    }

    public int getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
    
    
    
}
