package org.smart4j.chapter1.test;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter1.entity.Customer;
import org.smart4j.chapter1.helper.DatabaseHelper;
import org.smart4j.chapter1.service.ICustomerService;
import org.smart4j.chapter1.service.impl.CustomerServiceImpl;
import org.smart4j.chapter1.util.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2018/9/20.
 */
public class CustomerServiceTest {


    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceTest.class);


//    private final ICustomerService customerService;

    public CustomerServiceTest() {};

//    public CustomerServiceTest(CustomerServiceImpl customerService) {
//        this.customerService = customerService;
//    }

    @Before
    public void init(){
    }

    static {
//        DatabaseHelper.getConnection();
    }

    @Test
//    public  List<Customer> getCustomerList(){
    public  void getCustomerList(){
//        List<Customer> list = customerService.getCustomerList(keyWord);
//        Assert.assertEquals(2,list.size());
        Connection conn = null;
        try{
            String sql = "select * from customer";
            List<Customer> list = DatabaseHelper.queryEntityList(Customer.class,sql);
            list.forEach(l-> System.out.println(l.getName()));

//            conn = DatabaseHelper.getConnection();
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet result = stmt.executeQuery();
//            while (result.next()){
//                Customer customer = new Customer();
//                customer.setId(result.getLong("id"));
//                customer.setName(result.getString("name"));
//                customer.setContact(result.getString("contact"));
//                customer.setEmail(result.getString("email"));
//                customer.setRemark(result.getString("remark"));
//                customer.setTelephone(result.getInt("telephone"));
//                list.add(customer);
//            }
//            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseHelper.closeConnection();
        }
//        return Collections.EMPTY_LIST;
    }

    public Customer getCustomer(long id){
//        Customer customer = customerService.getCustomerById(id);
//        return customer;
        return null;
    }
}
