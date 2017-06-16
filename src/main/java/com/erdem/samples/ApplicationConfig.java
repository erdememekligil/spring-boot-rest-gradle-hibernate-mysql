package com.erdem.samples;

import com.erdem.samples.dao.UserRepository;
import com.erdem.samples.dao.UserRepositoryDao;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * Created by bilginc_user on 15.06.2017.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public UserRepositoryDao userRepositoryDao(UserRepository userRepository){
        return new UserRepositoryDao(userRepository);
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public Worker worker(){
        return new Worker();
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public GreetingController greetingController(){
        return new GreetingController();
    }
}
