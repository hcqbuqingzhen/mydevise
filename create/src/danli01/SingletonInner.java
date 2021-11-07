package danli01;

public class SingletonInner {
    private static class SingletonInnerHolder{
        private static SingletonInner singletonInner=new SingletonInner();
    }
    private SingletonInner(){
    }

    public static SingletonInner getSingleton() {
        return SingletonInnerHolder.singletonInner;
    }
}
