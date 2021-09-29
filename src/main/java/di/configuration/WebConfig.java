package di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configuration for web part of application
 * viewResolver Bean
 * sets view class JSTLView for JSP pages
 * as it is written in docs
 * and settings are get as in docs with prefix and suffix
 */
@Configuration
@ComponentScan("di")
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("./WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
}
