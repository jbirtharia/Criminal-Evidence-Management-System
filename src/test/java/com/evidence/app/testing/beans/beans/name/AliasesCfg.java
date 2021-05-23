package com.evidence.app.testing.beans.beans.name;

import com.evidence.app.testing.beans.beans.SimpleBean;
import com.evidence.app.testing.beans.beans.SimpleBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JayendraB
 * Created on 23/05/21
 */
@Configuration
public class AliasesCfg {

    @Bean(name = {"firstBean","secondBean"})
    SimpleBean simpleBean(){
        return new SimpleBeanImpl();
    }
}
