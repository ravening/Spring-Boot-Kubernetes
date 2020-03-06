package com.rakeshv.configmaps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "welcome")
@Configuration
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WelcomeConfiguration {
    private String message;
}
