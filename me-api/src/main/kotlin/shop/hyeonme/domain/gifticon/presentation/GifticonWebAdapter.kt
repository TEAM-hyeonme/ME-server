package shop.hyeonme.domain.gifticon.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import shop.hyeonme.common.annotation.WebAdapter
import shop.hyeonme.domain.gifticon.mapper.toRequest
import shop.hyeonme.domain.gifticon.presentation.web.req.CreateGifticonWebRequest
import shop.hyeonme.domain.gifticon.usecase.CreateGifticonUseCase
import javax.validation.Valid

@WebAdapter("/gifticon")
class GifticonWebAdapter(
    private val createGifticonUseCase: CreateGifticonUseCase,
) {
    @PostMapping("/admin")
    fun createGifticon(@RequestBody @Valid request: CreateGifticonWebRequest): ResponseEntity<Unit> =
        createGifticonUseCase.execute(request.toRequest())
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}