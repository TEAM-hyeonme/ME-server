package shop.hyeonme.common.annotation

import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Transactional(rollbackFor = [Exception::class])
annotation class UseCase
