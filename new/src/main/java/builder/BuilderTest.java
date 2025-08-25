package builder;

public class BuilderTest {
    public static void main(String[] args) {
        SQL.select("name","age").from("student").where("age > 18").build();

        SQL.update("student").where("id = 1").set("name","zhangsan").set("age",20).build();
    }
}
