package com.evidence.app.testing.beans.beans;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class DependentBeanImpl implements DependentBean{
    private SimpleBean simpleBean;
    public DependentBeanImpl(SimpleBean simpleBean){
        this.simpleBean = simpleBean;
    }
}
