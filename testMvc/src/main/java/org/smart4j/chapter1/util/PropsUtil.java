package org.smart4j.chapter1.util;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by Administrator on 2018/9/21.
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载配置文件
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                throw new FileNotFoundException(fileName + " file is not found");
            }
            properties = new Properties();
            properties.load(is);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("load properties failed");
        }finally {
            if(is != null){
                try{
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return properties;
    }

    /**
     * 获取属性值（可设置默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if (props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    public static int getInt(Properties props,String key,int defaultValue){
        int value = defaultValue;
        if (props.containsKey(key)){
            value = Integer.valueOf(props.getProperty(key));
        }
        return value;
    }

    public static Boolean getBoolean(Properties props,String key,Boolean defaultValue){
        Boolean value = defaultValue;
        if (props.containsKey(key)){
            String temp = props.getProperty(key);
            if (temp != null){
                value = true;
            }else {
                value = false;
            }
        }
        return value;
    }
}
