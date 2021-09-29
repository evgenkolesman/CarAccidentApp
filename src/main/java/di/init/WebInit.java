package di.init;

import di.configuration.DataConfig;
import di.configuration.SecurityConfig;
import di.configuration.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * Most important init class
 */

public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(WebConfig.class, DataConfig.class, SecurityConfig.class);
        ac.refresh();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        filter.setForceRequestEncoding(true);
        FilterRegistration.Dynamic encoding1 = servletContext.addFilter("encoding1", filter);
        encoding1.addMappingForUrlPatterns(null, false, "/*");
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration1 = servletContext.addServlet("app", servlet);
        registration1.setLoadOnStartup(1);
        registration1.addMapping("/");
    }
}
