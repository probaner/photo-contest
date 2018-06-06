package com.photo.contest.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
 
 
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
    
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
        web.ignoring().antMatchers("/resources/**");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
                .antMatchers("/", "/home","/getRegistrationForm", "/getloginForm","/getUserTable","/getDownload","/getContuctUs","/getForgetPasswordForm","/processRegistration","/imageViewer").permitAll()    
                /*.antMatchers("/getUserTable").hasAuthority("participate")*/
                .antMatchers("/json/**").hasAuthority("participate") 
                .antMatchers("/admin/json/**").hasAuthority("admin")
              /*.antMatchers("/").access("hasRole('perticipate') or hasRole('admin') or hasRole('judge')")
                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')")
                .antMatchers("/edit-user-*").access("hasRole('ADMIN') or hasRole('DBA')")*/
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/getloginForm")/*.successHandler(new RefererRedirectionAuthenticationSuccessHandler())*/
                .loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/login")
                .and().anonymous()
                .and().logout().    //logout configuration
        		logoutUrl("/logout"). 
        		logoutSuccessUrl("/login?message=Success")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
 
 
    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }
 
}