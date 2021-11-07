package Chain08;

public class App {
    public static void main(String[] args) {

        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Handler handler3 = new ConcreteHandler3(handler2);

        Request request1 = new Request(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);

        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);

        Request request3 = new Request(RequestType.TYPE2, "request3");
        handler3.handleRequest(request3);
    }
}
