import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration()
@ComponentScan("com.sk")
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class);
    }
}
