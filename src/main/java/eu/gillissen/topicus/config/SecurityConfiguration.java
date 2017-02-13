package eu.gillissen.topicus.config;

import eu.gillissen.topicus.service.UserDetailsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security Configuration
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Configures the HttpSecurity of the website.
     *
     * @param http The HttpSecurity object to configure.
     * @throws Exception when HttpSecurity::authorizeRequests fails
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/",
                "/products", "/product/show/*",
                "/console/**", //H2 console
                "/cart/**",
                "/order",
                "/register")
                .permitAll().anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/order/**" +
                "/user/**")
                .authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();

        // needed for H2 console
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    /**
     * Configures the user-authentication service.
     *
     * @param auth               The AuthenticationManager which is configured.
     * @param userDetailsService The service that provides the user-details.
     * @throws Exception when AuthenticationManagerBuilder::userDetailsService fails
     */
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth, UserDetailsRepositoryService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
