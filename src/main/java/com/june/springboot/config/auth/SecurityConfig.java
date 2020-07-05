package com.june.springboot.config.auth;

import com.june.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private final CustomUserTypesOAuth2UserService customUserTypesOAuth2UserService;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                    .headers().frameOptions().disable() //2 h2-console 화면을 사용하기 위한 옵션들을 비활성화
                    .and().authorizeRequests() //3 URL별로 권한 관리를 설정하는 옵션의 시작점
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**")
                    .hasRole(Role.USER.name()) //4 권한 관리 대상 지정 옵션
                    .anyRequest().authenticated() //5 설정된 값들 이외 나머지 url을 나타냄
                    .and().logout().logoutSuccessUrl("/") //6 로그아웃 성공시 "/" 이동
                    .and().oauth2Login() //7 로그인 기능에 대한 여러 설정의 진입점
                    .userInfoEndpoint() //8 로그인 성공이후 사용자 정보 가져올 때
                    .userService(customOAuth2UserService); //9 소셜 로그인 성공시 후속조치 진행
    }
}
