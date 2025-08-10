import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("strategy") // 扫描strategy包下(包含子目录)的组件
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
