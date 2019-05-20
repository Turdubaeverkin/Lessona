package kg.Lessons.Lessona.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class Securyconfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //.authorizeRequests()
                //.anyRequest()
                //.authenticated()
                .authorizeRequests().antMatchers("/image").permitAll().
                antMatchers("/m").hasRole("Admin").
                antMatchers("/massegeall").
                hasRole("Admin")
//                .antMatchers("/general").hasRole("SUPERVISOR")
//                .antMatchers("/general").hasRole("TELLER")

                .and().httpBasic().and().logout()
        //.invalidateHttpSession(true)
        // .deleteCookies("JSESSIONID")
        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Erkin").password("{noop}1234").roles("Admin");


        //                .and()
//                .withUser("TELLER")
//                .password("{noop}2")
//                .roles("TELLER")

        ;
    }
}