package com.evidence.app.testing.beans;

import com.evidence.app.testing.beans.beans.SimpleBean;
import com.evidence.app.testing.beans.configs.SimpleDependentCfg;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Slf4j
public class SimpleDependentConfigTest {

    @Test
    void testSimpleBeans(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleDependentCfg.class);
        SimpleDependentCfg simpleDependentCfg = ctx.getBean(SimpleDependentCfg.class);
        Assertions.assertNotNull(simpleDependentCfg);
        SimpleBean simpleBean = simpleDependentCfg.simpleBean();
        Assertions.assertNotNull(simpleBean);
    }
}
