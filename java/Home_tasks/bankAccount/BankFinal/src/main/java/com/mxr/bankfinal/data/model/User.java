package com.mxr.bankfinal.data.model;
import java.util.ArrayList; 
import com.mxr.bankfinal.util.BVNManager;

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
        return BVNManager.generateUniqueBvn();
    }

    public String getBvn(){
        return this.bvn;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
