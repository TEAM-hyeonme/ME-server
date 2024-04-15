package shop.hyeonme.me.global.config

import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import shop.hyeonme.me.common.annotation.CommandService
import shop.hyeonme.me.common.annotation.QueryService
import shop.hyeonme.me.common.annotation.Service
import shop.hyeonme.me.common.annotation.UseCase

@Configuration
@ComponentScan(
    basePackages = ["shop.hyeonme.me"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                UseCase::class,
                Service::class,
                QueryService::class,
                CommandService::class
            ]
        )
    ]
)
class ComponentScanConfig