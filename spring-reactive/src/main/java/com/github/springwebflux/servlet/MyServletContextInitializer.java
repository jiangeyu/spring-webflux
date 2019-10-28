package com.github.springwebflux.servlet;


import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:43 2019/10/27
 */
@HandlesTypes(value = {IMyServlet.class})
public class MyServletContextInitializer implements ServletContextInitializer {



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        List<IMyServlet> myServlets = new ArrayList<>();
//        for(Class imysevlet:servletContext.getS)


        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("",new AngleServlet());
        servletRegistration.addMapping("/hello");


        ServletRegistration.Dynamic filter = servletContext.addFilter("",AngleFilter.class);
        ((FilterRegistration.Dynamic) filter).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");



    }
}
