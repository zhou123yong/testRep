package org.smart4j.chapter1.controller;

import org.smart4j.chapter1.service.ICustomerService;
import org.smart4j.chapter1.service.IHelloService;
import org.smart4j.chapter1.service.impl.CGLibProxy;
import org.smart4j.chapter1.service.impl.DynamicProxy;
import org.smart4j.chapter1.service.impl.HelloServiceImpl;

import java.lang.reflect.Proxy;
//import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2018/9/25.
 */
//@Controller
public class CustomerController {

//    @AutoWired
    private ICustomerService customerService;

//    public static void main(String[] args) {
//        HelloProxy helloProxy = new HelloProxy();
//        helloProxy.sayHello();
//
//    }

    public static void main(String[] args) {
//        静态代理
//        IHelloService hello = new HelloServiceImpl();
//        DynamicProxy dynamicProxy = new DynamicProxy(hello);
//        IHelloService helloProxy = (IHelloService)Proxy.newProxyInstance(
//                hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),dynamicProxy
//        );
//        jdk动态代理
//        DynamicProxy dynamicProxy = new DynamicProxy(new HelloServiceImpl());
//        IHelloService hello = dynamicProxy.getProxy();
//        hello.sayHello();
//        cglib动态代理
        CGLibProxy cgLibProxy = new CGLibProxy();
        IHelloService hello = cgLibProxy.getProxy(HelloServiceImpl.class);
        hello.sayHello();

    }


}
