package eu.gillissen.topicus.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of web servlets.
 */
@Configuration
public class WebConfiguration {
    /**
     * Registers the H2 web console
     *
     * @return registered h2 console servlet
     */
    @Bean
    ServletRegistrationBean h2ServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
