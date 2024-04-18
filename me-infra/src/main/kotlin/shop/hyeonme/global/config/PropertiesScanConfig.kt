package shop.hyeonme.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import shop.hyeonme.global.jwt.properties.JwtProperties
import shop.hyeonme.thirdparty.apple.properties.AppleProperties

@Configuration
@ConfigurationPropertiesScan(
    basePackageClasses = [
        AppleProperties::class,
        JwtProperties::class
    ])
class PropertiesScanConfig