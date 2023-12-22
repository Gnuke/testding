package com.gorea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import com.gorea.login.CustomAccessDeniedHandler;
import com.gorea.login.LoginDetailService;
import com.gorea.login.LoginFail;
import com.gorea.login.LoginOauthUserService;
import com.gorea.login.LoginSuccess;


@EnableWebSecurity
@Configuration
public class Gorea_LoginSecurity_Config {
	
	// 로그인 성공시
	@Autowired
	private LoginSuccess loginSuccess;
	// 로그인 실패시
	@Autowired
	private LoginFail loginFail;
	@Autowired
	private LoginDetailService loginDetailService;
	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	@Autowired
	private LoginOauthUserService loginOauthUserService; 
	
//	@Bean
//    public HttpFirewall defaultHttpFirewall() {
//        return new DefaultHttpFirewall();
//    }
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf ->csrf.disable()).cors(cors ->cors.disable());
                
		http.authorizeHttpRequests(request -> request
        		.requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/korean/user/**").hasAnyRole("ADMIN, USER")
                .anyRequest().permitAll()
			)
			.exceptionHandling(handling ->handling
					.accessDeniedHandler(customAccessDeniedHandler)
			)
			.formLogin(login -> login
					.loginPage("/korean/login.do")
				    .loginProcessingUrl("/loginProcKr")
				    .successHandler(loginSuccess)
				    .failureHandler(loginFail)
            )
            .logout(logout -> logout
            		.invalidateHttpSession(true)
            	    .deleteCookies("JESSIONID")
            	    .logoutUrl("/logout.do")
            	    .logoutSuccessUrl("/korean/main.do")
           
            )
            .rememberMe(me -> me
                	.key("rememberKey")
            		.rememberMeCookieName("rememberMeCookieName")
            		.rememberMeParameter("remember-me")
            		.tokenValiditySeconds(60 * 60 * 24 * 7)
            		.userDetailsService(loginDetailService)
            );
		
		http.oauth2Login(login -> login
			    .loginPage("/korean/login.do")
			    .userInfoEndpoint()
			        .userService(loginOauthUserService)
			        .and()
			    .defaultSuccessUrl("/korean/main.do")
			);
		
        return http.build();
        
    }
}
