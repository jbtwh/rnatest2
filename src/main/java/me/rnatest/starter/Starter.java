package me.rnatest.starter;

import me.rnatest.conf.MainConfig;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JspServlet;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;


public class Starter {
    public static void main(String[] args) throws Exception {

        String webappPort = System.getenv("PORT");
        if(webappPort == null || webappPort.isEmpty()) {
            webappPort = "8080";
        }

       // File base = new File("src/main/webapp/");
        Tomcat tomcat = new Tomcat();
        //tomcat.setBaseDir(base.getAbsolutePath());
        tomcat.setPort(Integer.valueOf(webappPort));
        Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(MainConfig.class);
        //webCtx.setParent(ctx);
        context.setApplicationLifecycleListeners(new Object[]{new ContextLoaderListener(webCtx)});

        System.err.println(JspServlet.class.getProtectionDomain().getCodeSource());

        Wrapper wds=tomcat.addServlet(context.getPath(), "dispatcherServlet", new DispatcherServlet(webCtx));
        wds.setLoadOnStartup(1);
        wds.addMapping("/*");
        //context.addServletMapping("/ds/*", "dispatcherServlet");

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        FilterDef encf = new FilterDef();
        encf.setFilter(characterEncodingFilter);
        encf.setFilterName("encoding-filter");
        context.addFilterDef(encf);

        FilterMap encm = new FilterMap();
        encm.setFilterName("encoding-filter");
        encm.addURLPattern("/*");

        context.addFilterDef(encf);
        context.addFilterMap(encm);

        tomcat.start();
        tomcat.getServer().await();
    }
}
