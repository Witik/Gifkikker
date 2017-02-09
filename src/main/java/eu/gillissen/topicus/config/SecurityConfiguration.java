package eu.gillissen.topicus.config;

import eu.gillissen.topicus.service.UserDetailsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/",
                "/products", "/product/show/*",
                "/console/**",
                "/cart/**",
                "/order")
                .permitAll().anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/order/**" +
                "/user/**")
                .authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsRepositoryService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
