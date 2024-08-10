package me.kirenai.re.nourishment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(
        scanBasePackages = {
                "me.kirenai.re.nourishment",
                "me.kirenai.re.validation"
        }
)
@EnableR2dbcRepositories(basePackages = "me.kirenai.re.nourishment.infrastructure.repository.r2dbc")
public class NourishmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(NourishmentApplication.class, args);
    }

}
