public class PasswordValidator {
    

    public String validatePassword(String password) {
        if(password.matches("^(?=.+[\\d\\W])\\S+") && password.length() >= 8 && password.length() <= 20) {
            return "Valid password";
        }
        return "Invalid password";
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        System.out.println(validator.validatePassword("Passwordu
        hj"));
    }
}
