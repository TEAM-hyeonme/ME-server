package shop.hyeonme.me.domain.auth.service

import shop.hyeonme.me.common.annotation.Service

@Service
class AuthService(
    queryAuthService: QueryAuthService
) : QueryAuthService by queryAuthService