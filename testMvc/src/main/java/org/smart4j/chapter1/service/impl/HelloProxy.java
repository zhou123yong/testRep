package org.smart4j.chapter1.service.impl;

import org.smart4j.chapter1.service.IHelloService;

/**
 * Created by Administrator on 2018/9/25.
 */
public class HelloProxy implements IHelloService {

    private IHelloService helloService;

    public HelloProxy() {
        helloService = new HelloServiceImpl();
    }

    @Override
    public void sayHello() {
        before();
        helloService.sayHello();
        after();

    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
