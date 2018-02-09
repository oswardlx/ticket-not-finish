package com.demo;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.log.Log;
import com.jfinal.log.Log4jLogFactory;
import com.jfinal.template.Engine;

import java.io.InputStream;

public class DemoConfig extends JFinalConfig {
    private Log4jLogFactory log4jLogFactory = new Log4jLogFactory();
    private  Log log = log4jLogFactory.getLog(DemoConfig.class);
    public void configConstant(Constants me) {
        try {
//            String path = this.getClass().getResourceAsStream("/jdbc.properties");
            loadPropertyFile("jdbc.properties");
            me.setDevMode(getPropertyToBoolean("devMode", false).booleanValue());
            me.setMaxPostSize(1024*1024*1024);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("加载常量（configConstant）出错，请解决问题后重新启动tomcat！！！");
        }
    }
    public void configRoute(Routes me) {
        log.debug("1312312");
        me.add("/hello",HelloController.class);
    }


    public void configEngine(Engine me) {

    }


    public void configPlugin(Plugins me) {

    }


    public void configInterceptor(Interceptors me) {

    }


    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler());
    }

    public static void main(String[] args) {
        InputStream resourceAsStream = DemoConfig.class.getResourceAsStream("/jdbc.properties");

        System.out.println(resourceAsStream);
    }
}