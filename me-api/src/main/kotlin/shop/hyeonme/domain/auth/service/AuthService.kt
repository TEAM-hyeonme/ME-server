package shop.hyeonme.domain.auth.service

import shop.hyeonme.common.annotation.FacadeService

@FacadeService
class AuthService(
    queryAuthService: QueryAuthService,
    commandAuthService: CommandAuthService
) : QueryAuthService by queryAuthService,
    CommandAuthService by commandAuthService