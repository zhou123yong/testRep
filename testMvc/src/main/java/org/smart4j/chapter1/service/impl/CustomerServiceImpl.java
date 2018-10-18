package org.smart4j.chapter1.service.impl;

import org.smart4j.chapter1.entity.Customer;
import org.smart4j.chapter1.service.ICustomerService;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2018/9/20.
 */
@WebService
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public List<Customer> getCustomerList(String keyWord) {
        return null;
    }

    @Override
    public Customer getCustomerById(long id) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void delCustomer(long id) {

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
}
