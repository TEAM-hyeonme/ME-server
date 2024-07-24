package shop.hyeonme.domain.gifticon.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class GifticonService(
    commandGifticonService: CommandGifticonService,
    queryGifticonService: QueryGifticonService
) : CommandGifticonService by commandGifticonService,
    QueryGifticonService by queryGifticonService