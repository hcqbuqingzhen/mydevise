package danli01;

public class SingletonLazy {
    // volatile 防止重排序
    private volatile static SingletonLazy singleton;
    private SingletonLazy(){
    }

    public static SingletonLazy getSingleton() {

            if (singleton == null) {
                synchronized (SingletonLazy.class) {
                    if(singleton==null) {
                        singleton = new SingletonLazy();
                    }
                }
            }

        return singleton;

    }
}
