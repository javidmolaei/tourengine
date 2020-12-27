package ir.company.tourengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {
        try {
            auth.jdbcAuthentication().dataSource(dataSource)
    //                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                    .passwordEncoder(new BCryptPasswordEncoder())
                    .usersByUsernameQuery("select MOBILE, password , enabled from USERS where MOBILE = ?")
                    .authoritiesByUsernameQuery("select MOBILE , roles from authorities where MOBILE = ?");
        } catch (Exception e) {
            System.out.println("[F.E.A.R] : "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/**", "/fonts/**", "/images/**", "/scss/**", "/js/**", "/lp/**", "/svgs/**", "/icons/**", "/webfonts/**", "/authentication/register/**")
                .permitAll()

                .and()
                .authorizeRequests().antMatchers("/users/**","/about/**")
//                .hasRole("SUPER_ADMIN ")
                .hasAuthority("SUPER_ADMIN")


//                .and()
//                .authorizeRequests().antMatchers("/pmusers/**","/transactions/**")
//                .hasRole("SUPER_ADMIN ")
//                .hasAuthority("ADMIN")

                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").usernameParameter("MOBILE").permitAll().and().logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
