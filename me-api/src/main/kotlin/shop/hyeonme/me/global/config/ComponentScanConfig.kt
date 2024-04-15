package shop.hyeonme.me.global.config

import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import shop.hyeonme.me.common.annotation.*

@Configuration
@ComponentScan(
    basePackages = ["shop.hyeonme.me"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                UseCase::class,
                ReadOnlyUseCase::class,
                Service::class,
                QueryService::class,
                CommandService::class
            ]
        )
    ]
)
class ComponentScanConfig