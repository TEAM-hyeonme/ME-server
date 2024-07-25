package shop.hyeonme.global.security

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils
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
            .mvcMatchers(HttpMethod.PATCH, "/auth").permitAll()
            .mvcMatchers(HttpMethod.DELETE, "/auth").authenticated()

            // Exercise
            .mvcMatchers(HttpMethod.PUT, "/exercise").authenticated()
            .mvcMatchers(HttpMethod.GET, "/exercise").authenticated()
            .mvcMatchers(HttpMethod.GET, "/exercise/top").authenticated()

            // User
            .mvcMatchers(HttpMethod.GET, "/user").authenticated()

            // Coupon
            .mvcMatchers(HttpMethod.GET, "/coupon").authenticated()
            .mvcMatchers(HttpMethod.GET, "/coupon/{id}").authenticated()

            // Gifticon
            .mvcMatchers(HttpMethod.GET, "/gifticon").authenticated()
            .mvcMatchers(HttpMethod.GET, "/gifticon/{id}").authenticated()
            .mvcMatchers(HttpMethod.POST, "/gifticon/{id}").authenticated()
            .mvcMatchers(HttpMethod.POST, "/gifticon/admin").hasRole(ADMIN)
            .mvcMatchers(HttpMethod.POST, "/gifticon/admin/{id}").hasRole(ADMIN)

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