package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import storage.StorageProperties;

@SpringBootApplication
@ComponentScan({ "controllers", "storage"})
@EntityScan({"models"})
@EnableJpaRepositories(basePackages = {"controllers"})
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() { 
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
