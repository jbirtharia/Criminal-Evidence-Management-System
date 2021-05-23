package com.evidence.app.testing.beans;

import com.evidence.app.testing.beans.beans.SimpleBean;
import com.evidence.app.testing.beans.configs.OneBeanConfig;
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
public class OneSimpleConfigTest {

    @Test
    void testOneSimpleConfig(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(OneBeanConfig.class);
        SimpleBean firstBean = ctx.getBean(SimpleBean.class);
        SimpleBean secondBean = ctx.getBean(SimpleBean.class);
        log.info("first bean : "+firstBean+" \n and second bean : "+secondBean);
        Assertions.assertEquals(firstBean,secondBean);
    }
}
