package templatemethod01;

public class App {
    public static void main(String[] args) {
        Beverage beverage=new CaffeineBeverage();
        beverage.prepareRecipe();
        System.out.println("----");
        Beverage beverage1=new TeaBeverage();
        beverage1.prepareRecipe();
    }
}
