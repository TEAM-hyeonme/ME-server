package shop.hyeonme.domain.user.usecase

import shop.hyeonme.common.annotation.ReadOnlyUseCase
import shop.hyeonme.domain.point.service.PointService
import shop.hyeonme.domain.user.service.UserService
import shop.hyeonme.domain.user.usecase.data.res.QueryMyPageResponseData

@ReadOnlyUseCase
class QueryMyPageUseCase(
    private val userService: UserService,
    private val pointService: PointService
) {
    fun execute(): QueryMyPageResponseData {
        val user = userService.findCurrentUser()
        val point = pointService.countPoint(user.id)

        return QueryMyPageResponseData(
            name = user.name,
            role = user.role,
            point = point
        )
    }
}