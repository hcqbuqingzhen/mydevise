package danli01;

public class Singleton {
    public static Singleton singleton=new Singleton();
    private Singleton(){

    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
