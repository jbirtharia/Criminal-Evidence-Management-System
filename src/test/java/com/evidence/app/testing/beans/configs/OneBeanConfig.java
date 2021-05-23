package com.evidence.app.testing.beans.configs;

import com.evidence.app.testing.beans.beans.SimpleBean;
import com.evidence.app.testing.beans.beans.SimpleBeanImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Slf4j
public class OneBeanConfig {

    @Bean
    SimpleBean simpleBean(){
        return new SimpleBeanImpl();
    }
}
