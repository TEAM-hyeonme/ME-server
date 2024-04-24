package shop.hyeonme.global.security

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.web.cors.CorsUtils
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import shop.hyeonme.global.config.FilterConfig
import shop.hyeonme.global.jwt.JwtTokenParser
import shop.hyeonme.global.security.handler.CustomAccessDeniedHandler
import shop.hyeonme.global.security.handler.CustomAuthenticationEntryPointHandler

@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenParser: JwtTokenParser
) {
    companion object {
        const val USER = "USER"
        const val ADMIN = "ADMIN"
    }

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .cors()
            .and()
            .csrf().disable()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
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

            .exceptionHandling()
            .authenticationEntryPoint(CustomAuthenticationEntryPointHandler())
            .accessDeniedHandler(CustomAccessDeniedHandler())
            .and()

            .apply(FilterConfig(jwtTokenParser))
            .and()
            .build()
}