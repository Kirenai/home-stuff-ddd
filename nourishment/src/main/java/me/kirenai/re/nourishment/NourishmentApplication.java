package me.kirenai.re.nourishment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "me.kirenai.re.nourishment",
                "me.kirenai.re.validation"
        }
)
public class NourishmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(NourishmentApplication.class, args);
    }

}
