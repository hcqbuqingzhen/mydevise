package gongchang02;

public class APP {
    public static void main(String[] args) {
        Factory factory=new SimpleFactory();
        Product product = factory.createProduct("1");
        System.out.println("----------------------------------");


    }

}
