package shop.hyeonme.domain.user.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class UserService(
    commandUserService: CommandUserService,
    queryUserService: QueryUserService
) : CommandUserService by commandUserService,
    QueryUserService by queryUserService