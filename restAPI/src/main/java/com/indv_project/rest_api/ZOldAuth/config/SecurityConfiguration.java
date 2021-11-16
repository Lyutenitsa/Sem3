//package com.indv_project.rest_api.authFilter.config;
//
//import com.indv_project.rest_api.authFilter.JWTAuthenticationFilter;
//import com.indv_project.rest_api.authFilter.JWTAuthorisationFilter;
//import com.indv_project.rest_api.services.AuthenticationUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final AuthenticationUserService authenticationUserDetailService;
//    private static AuthConfigConstants constants;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, constants.SIGN_UP_URL).permitAll()
//                //ROLE BASED AUTHENTICATION START
//                .antMatchers("/login").permitAll()//.hasAnyAuthority("USER")
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/api/**").permitAll()
//                //ROLE BASED AUTHENTICATION END
//                .anyRequest().authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorisationFilter(authenticationManager()))
//                // this disables session creation on Spring Security
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
//    }
//}
