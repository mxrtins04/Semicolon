package Customer;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    continue;
                }
                throw new IllegalArgumentException("Name must contain only letters");
            }
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
        if (number.length() != 11) {
            throw new IllegalArgumentException("Phone number must be 11 digits");
        }
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Phone number must contain only numbers");
            }
        this.phoneNumber = number;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }
}
