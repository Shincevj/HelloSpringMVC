package org.cims.hellospringmvc.config;

import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.ContextLoaderListener;

public class SpringWebAppInitializer implements WebApplicationInitializer {
  // the method "onStartup" need java 1.8: use toolchain to fix it
  @Override
  public void onStartup(ServletContext servletContext) {
    // Create the 'root' application context
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(DomainConfig.class);

    // Manage the lifecycle of the root application context
    servletContext.addListener(new ContextLoaderListener(rootContext));

    // Create the dispatcher servlet's application context
    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.register(ServletConfig.class);

    // Register and map the dispatcher servlet
    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
