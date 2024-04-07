package com.company.autobase;
import com.company.autobase.menu.MenuExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class AppStarter {
    private final MenuExecutor menuExecutor;
    @Bean
    public ApplicationRunner init() {
        log.debug("ApplicationRunner has started");
        return args -> {
            menuExecutor.printMenu();
        };
    }
}
