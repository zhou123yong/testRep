package org.smart4j.chapter1.service;

import org.smart4j.chapter1.entity.Customer;

import java.util.List;

/**
 * Created by Administrator on 2018/9/20.
 */
public interface ICustomerService {

    List<Customer> getCustomerList(String keyWord);

    Customer getCustomerById(long id);

    void addCustomer(Customer customer);

    void delCustomer(long id);

    Customer updateCustomer(Customer customer);
}
