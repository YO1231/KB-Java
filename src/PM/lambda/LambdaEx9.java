package PM.lambda;

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

@FunctionalInterface
interface Creator {
    User create(String name);
}

public class LambdaEx9 {
    public static void main(String[] args) {
        Creator c1 = (name -> new User(name));
        Creator c2 = User::new;
    }
}
