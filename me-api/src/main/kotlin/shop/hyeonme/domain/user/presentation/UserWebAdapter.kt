package shop.hyeonme.domain.user.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import shop.hyeonme.common.annotation.WebAdapter
import shop.hyeonme.domain.user.mapper.toResponse
import shop.hyeonme.domain.user.presentation.data.res.QueryMyPageWebResponse
import shop.hyeonme.domain.user.usecase.QueryMyPageUseCase

@WebAdapter("/user")
class UserWebAdapter (
    private val queryMyPageUseCase: QueryMyPageUseCase
){
    @GetMapping
    fun queryMyPage(): ResponseEntity<QueryMyPageWebResponse> =
        queryMyPageUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.OK).body(it.toResponse()) }

}