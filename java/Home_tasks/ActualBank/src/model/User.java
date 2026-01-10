package src.model;

import java.util.ArrayList; 

public class User {
    private String name;
    private String email;
    private final String bvn;
    private Account account;
    

    public User(String name, String email){
        this.name = name;
        this.email = email;
        this.bvn = generateBvn();
    }

    private String generateBvn(){
        return Bank.generateBvn();
    }

    public String getBvn(){
        return this.bvn;
    }

	public String getName() {
		return this.name;
	}

    

}
