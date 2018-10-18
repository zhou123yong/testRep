package org.smart4j.chapter1.helper;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter1.util.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2018/9/21.
 */
public final class DatabaseHelper {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final String Driver;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<>();
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    static {
        Properties config = PropsUtil.loadProps("config.properties");
        Driver = config.getProperty("jdbc.driver");
        URL = config.getProperty("jdbc.url");
        USERNAME = config.getProperty("jdbc.username");
        PASSWORD = config.getProperty("jdbc.password");
        try {
            DATA_SOURCE.setDriverClassName(Driver);
            DATA_SOURCE.setUrl(URL);
            DATA_SOURCE.setUsername(USERNAME);
            DATA_SOURCE.setPassword(PASSWORD);
            Class.forName(Driver);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("can not load driver",e);
        }
    }

    public static Connection getConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if (conn != null) {
            try {
//                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                conn = DATA_SOURCE.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                CONNECTION_HOLDER.set(conn);
            }

        }
        return conn;
    }

    public static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if (conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
                logger.error("close conn failed",e);
            }finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass,String sql,Object ...params){
        List<T> entityList = null;
        try{
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn,sql,new BeanListHandler<>(entityClass),params);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass,String sql,Object ...params){
        T entity = null;
        try{
            Connection conn = getConnection();
            entity = QUERY_RUNNER.query(conn,sql,new BeanHandler<>(entityClass),params);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return entity;
    }
}
