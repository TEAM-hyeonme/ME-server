package shop.hyeonme.domain.point.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class PointService(
    queryPointService: QueryPointService,
    commandPointService: CommandPointService
) : QueryPointService by queryPointService,
    CommandPointService by commandPointService