package org.smart4j.chapter1.service.impl;

import org.smart4j.chapter1.service.IHelloService;

/**
 * Created by Administrator on 2018/9/25.
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public void sayHello() {
        String name = "jay";
        System.out.println("hello " + name);
    }
}
