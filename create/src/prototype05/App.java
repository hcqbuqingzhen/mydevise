package prototype05;

public class App {
    public static void main(String[] args) {
        Prototype prototype=new ConcretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());

    }
}
