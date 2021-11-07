package gongchang03;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory1=new ConcreteFactory1();
        AbstractProductA productA = abstractFactory1.createProductA();
        AbstractProductB productB = abstractFactory1.createProductB();
        AbstractFactory abstractFactory2=new ConcreteFactory2();
        AbstractProductA productA1 = abstractFactory2.createProductA();
        AbstractProductB productB1 = abstractFactory2.createProductB();
    }
}
