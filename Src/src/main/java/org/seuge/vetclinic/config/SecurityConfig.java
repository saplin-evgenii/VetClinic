package org.seuge.vetclinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

import static org.seuge.vetclinic.config.util.SecurityConsts.QUERY_AUTH_BY_USERNAME;
import static org.seuge.vetclinic.config.util.SecurityConsts.QUERY_USER_BY_USERNAME;

/**
 * Spring Security configuration
 *
 * @author Seuge
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(QUERY_USER_BY_USERNAME)
                .authoritiesByUsernameQuery(QUERY_AUTH_BY_USERNAME);
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and().formLogin()
                .defaultSuccessUrl("/", false)
                .and().exceptionHandling().accessDeniedPage("/forbidden");

    }
}
