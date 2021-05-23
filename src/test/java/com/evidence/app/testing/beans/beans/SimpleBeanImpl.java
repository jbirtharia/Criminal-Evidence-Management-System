package com.evidence.app.testing.beans.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Component
@Slf4j
public class SimpleBeanImpl implements SimpleBean{

    public SimpleBeanImpl(){
      log.info("[SimpleBeanImpl instantiated]");
    }

    @Override
    public String toString() {
        return "SimpleBeanImpl { code : "+hashCode()+" }";
    }
}
