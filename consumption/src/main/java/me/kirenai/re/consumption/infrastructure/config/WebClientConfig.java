package me.kirenai.re.consumption.infrastructure.config;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClientNourishment(WebClient.Builder builder,
                                          ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        return builder.baseUrl("http://NOURISHMENT").filter(loadBalancerExchangeFilterFunction).build();
    }

}
