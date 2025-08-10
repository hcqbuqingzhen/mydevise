package chain;

import chain.handler.Validator;

public class App {
    public static void main(String[] args) {
        User user = new User();
        user.setName("John");
        user.setAge(30);
        user.setAddress("12sasa");
        Validator validator = new Validator();
        validator.validate(user);
    }
}
