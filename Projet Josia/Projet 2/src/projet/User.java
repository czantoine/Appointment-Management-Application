/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author josia
 */

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
