package shop.hyeonme.domain.auth.service

import shop.hyeonme.common.annotation.Service

@Service
class AuthService(
    queryAuthService: QueryAuthService
) : QueryAuthService by queryAuthService