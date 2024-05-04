package shop.hyeonme.domain.point.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class PointService(
    commandPointService: CommandPointService,
    queryPointService: QueryPointService
) : CommandPointService by commandPointService,
    QueryPointService by queryPointService