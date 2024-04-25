package shop.hyeonme.global.config

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import shop.hyeonme.global.filter.ExceptionFilter
import shop.hyeonme.global.filter.JwtRequestFilter
import shop.hyeonme.global.jwt.JwtTokenParser

class FilterConfig(
    private val jwtTokenParser: JwtTokenParser
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtRequestFilter(jwtTokenParser), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionFilter(), JwtRequestFilter::class.java)
    }
}