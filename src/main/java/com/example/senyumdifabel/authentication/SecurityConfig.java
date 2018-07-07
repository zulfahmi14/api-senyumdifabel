package com.example.senyumdifabel.authentication;


import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Authentication : User --> Roles

//    protected BasicDataSource dataSource = new BasicDataSource();
//    dataSource
//    dataSource.setDriverClassName(env.getProperty("mysql.driver"));
//    dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
//    dataSource.setUsername(env.getProperty("mysql.username"));
//    dataSource.setPassword(env.getProperty("mysql.password"));

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_email, user_password, enabled"
                        + " from user where user_email=?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from authorities where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());

        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin123").roles("USER");
//        .and().withUser("test1").password("test123").roles("ADMIN");
    }

//        @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("test").password("test123").roles("USER").and()
//                .withUser("test1").password("test123").roles("ADMIN");
//    }

    // Authorization : Role -> Access
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().authorizeRequests()

//                .antMatchers(HttpMethod.POST, "/pelapor/**", "/laporan/**", "/uploadFile/**")
//                .permitAll()
//
                .antMatchers( "/auth/**")
                    .hasRole("USER")
                .antMatchers("/register").permitAll()
//                .antMatchers(HttpMethod.POST, "/petugas/**")
//                .hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/**")
//                .hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/**")
//                .hasRole("ADMIN")
                .and().csrf().disable().headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
