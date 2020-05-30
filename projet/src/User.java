/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antoine
 */
public class User {
    private String email;
    private String motdepasse;
    private String type;

    public User(String email, String motdepasse, String type) {
        this.email = email;
        this.motdepasse = motdepasse;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getType() {
        return type;
    }
    
    
    
}

