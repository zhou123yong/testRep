package org.smart4j.chapter1.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/10/8.
 */
public class test {

    public static void main(String[] args,HttpServletRequest request) {
        try {
            request.getParameterValues("a");
            request.getParameter("a");
            request.getAttribute("a");
            request.getPathInfo();
            return;
        } finally {
            System.out.println( "Finally" );
        }
    }


}
