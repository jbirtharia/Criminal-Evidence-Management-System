package com.evidence.app.testing.beans.configs;

import com.evidence.app.testing.beans.beans.DependentBean;
import com.evidence.app.testing.beans.beans.DependentBeanImpl;
import com.evidence.app.testing.beans.beans.SimpleBean;
import com.evidence.app.testing.beans.beans.SimpleBeanImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Configuration
@Slf4j
public class SimpleDependentCfg {

    @Bean
    public SimpleBean simpleBean(){
        log.info("----> Creating 'SimpleBean' ");
        return new SimpleBeanImpl();
    }

    @Bean
    public DependentBean dependentBean(){
        return new DependentBeanImpl(simpleBean());
    }
}
