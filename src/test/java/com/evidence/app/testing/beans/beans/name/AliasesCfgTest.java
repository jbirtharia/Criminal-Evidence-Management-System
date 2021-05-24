package com.evidence.app.testing.beans.beans.name;

import com.evidence.app.testing.beans.beans.SimpleBean;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author JayendraB
 * Created on 23/05/21
 */
@Slf4j
 class AliasesCfgTest {

    @Test
    void testSimpleBeans(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AliasesCfg.class);
        SimpleBean firstBean = context.getBean("firstBean",SimpleBean.class);
        assertNotNull(firstBean);
        SimpleBean secondBean = context.getBean("secondBean",SimpleBean.class);
        assertNotNull(secondBean);
//      This case proves that by default bean scope is singleton in Spring context
        assertEquals(firstBean,secondBean);

//      No bean is created by the name of simpleBean (i.e method name in config file) is created in Spring context
        assertThrows(NoSuchBeanDefinitionException.class,()-> context.getBean("simpleBean",SimpleBean.class));

        for (String beanName:context.getBeanDefinitionNames()) {
            log.info("Bean : " + beanName + " of type " + context.getBean(beanName).getClass().getSimpleName());
        }

        context.close();
    }

}
