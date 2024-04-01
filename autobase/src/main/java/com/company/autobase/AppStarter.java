package com.company.autobase;
import com.company.autobase.menu.MenuExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppStarter {
    @Autowired
    MenuExecutor menuExecutor;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);

    @Bean
    public ApplicationRunner init() {
        LOGGER.info("ApplicationRunner has started");
        return args -> {
            menuExecutor.printMenu();
        };
    }
}
