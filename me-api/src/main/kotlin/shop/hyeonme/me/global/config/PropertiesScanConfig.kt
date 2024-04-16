package shop.hyeonme.me.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import shop.hyeonme.me.global.jwt.properties.JwtProperties
import shop.hyeonme.me.thirdparty.apple.properties.AppleProperties

@Configuration
@ConfigurationPropertiesScan(
    basePackageClasses = [
        AppleProperties::class,
        JwtProperties::class
    ])
class PropertiesScanConfig