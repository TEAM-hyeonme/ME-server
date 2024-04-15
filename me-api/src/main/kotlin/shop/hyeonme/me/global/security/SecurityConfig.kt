package shop.hyeonme.me.global.security

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.web.cors.CorsUtils
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher

@EnableWebSecurity
class SecurityConfig {
    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .cors()
            .and()
            .csrf().disable()

            .formLogin().disable() // 임시

            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            // Health
            .mvcMatchers(HttpMethod.GET, "/health").permitAll()

            // Auth
            .mvcMatchers(HttpMethod.GET, "/auth/apple").permitAll()
            .mvcMatchers(HttpMethod.POST, "/auth/apple").permitAll()

            .anyRequest().authenticated()
            .and()

            .build()
}