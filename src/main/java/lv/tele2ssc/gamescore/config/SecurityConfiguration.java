/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
/**
 *
 * @author vitasava
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired()
    BCryptPasswordEncoder passwordEncoder; 

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select email, password, 1 from user where email=?")
                .authoritiesByUsernameQuery("select u.email,r.role_name from user u, role r,user_role urp "
                        + "where u.id=urp.user_id and r.id=urp.role_id and u.email=?")
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        //.passwordEncoder(passwordEncoder);


//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/assets/**").permitAll()                
                .antMatchers("/login/**").permitAll()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").hasAnyAuthority("admin")
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and().cors()
                .and().csrf().disable().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
                .and().headers().frameOptions().disable();
       
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){        
    	return new BCryptPasswordEncoder();
    }
   
}
