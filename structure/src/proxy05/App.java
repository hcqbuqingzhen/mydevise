package proxy05;

public class App {
    public void test(){
        // 一个买家要买房的话直接跟中介（代理）大交道就可以了
        Proxy proxy = new Proxy();
        proxy.buyHouse();
    }
}
