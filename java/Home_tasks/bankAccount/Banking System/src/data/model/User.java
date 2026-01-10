package data.model;

import java.util.ArrayList; 

public class User {
    private String name;
    private String email;
    private final String bvn;
    private ArrayList<Account> accounts;
    
    public User(String name, String email){
        this.name = name;
        this.email = email;
        this.bvn = generateBvn();
    }

    private String generateBvn(){
        String bvn = "3";
        return bvn;
    }

    public String getBvn(){
        return this.bvn;
    }
}
