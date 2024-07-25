package shop.hyeonme.domain.gifticon.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import shop.hyeonme.common.annotation.WebAdapter
import shop.hyeonme.domain.gifticon.mapper.toRequest
import shop.hyeonme.domain.gifticon.mapper.toResponse
import shop.hyeonme.domain.gifticon.presentation.web.req.CreateGifticonWebRequest
import shop.hyeonme.domain.gifticon.presentation.web.res.CreateGifticonWebResponse
import shop.hyeonme.domain.gifticon.presentation.web.res.QueryGifticonDetailsWebResponse
import shop.hyeonme.domain.gifticon.presentation.web.res.QueryGifticonsWebResponse
import shop.hyeonme.domain.gifticon.usecase.CreateGifticonUseCase
import shop.hyeonme.domain.gifticon.usecase.ExchangeGifticonUseCase
import shop.hyeonme.domain.gifticon.usecase.QueryGifticonDetailsUseCase
import shop.hyeonme.domain.gifticon.usecase.QueryGifticonsUseCase
import shop.hyeonme.domain.inventory.mapper.toRequest
import shop.hyeonme.domain.inventory.presentation.req.web.CreateInventoriesWebRequest
import shop.hyeonme.domain.inventory.usecase.CreateInventoriesUseCase
import java.util.*
import javax.validation.Valid

@WebAdapter("/gifticon")
class GifticonWebAdapter(
    private val createGifticonUseCase: CreateGifticonUseCase,
    private val queryGifticonsUseCase: QueryGifticonsUseCase,
    private val exchangeGifticonUseCase: ExchangeGifticonUseCase,
    private val queryGifticonDetailsUseCase: QueryGifticonDetailsUseCase,
    private val createInventoriesUseCase: CreateInventoriesUseCase
) {
    @GetMapping
    fun queryGifticons(): ResponseEntity<QueryGifticonsWebResponse> =
        queryGifticonsUseCase.execute()
           .let { ResponseEntity.ok(it.toResponse()) }

    @GetMapping("/{id}")
    fun queryGifticonDetails(@PathVariable id: UUID): ResponseEntity<QueryGifticonDetailsWebResponse> =
        queryGifticonDetailsUseCase.execute(id)
            .let { ResponseEntity.ok(it.toResponse()) }

    @PostMapping("/{id}")
    fun exchangeGifticon(@PathVariable id: UUID): ResponseEntity<Unit> =
        exchangeGifticonUseCase.execute(id)
           .let { ResponseEntity.status(HttpStatus.CREATED).build() }


    @PostMapping("/admin")
    fun createGifticon(@RequestBody @Valid request: CreateGifticonWebRequest): ResponseEntity<CreateGifticonWebResponse> =
        createGifticonUseCase.execute(request.toRequest())
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it.toResponse()) }

    @PostMapping("/admin/{id}")
    fun createInventories(@PathVariable id: UUID, @RequestBody @Valid request: CreateInventoriesWebRequest): ResponseEntity<Unit> =
        createInventoriesUseCase.execute(id, request.toRequest())
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}