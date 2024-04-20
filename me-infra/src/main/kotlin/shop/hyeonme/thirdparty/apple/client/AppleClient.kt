package shop.hyeonme.thirdparty.apple.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import shop.hyeonme.thirdparty.apple.data.ApplePublicKeys

@FeignClient(
    name = "AppleClient",
    url = "https://appleid.apple.com/auth"
)
interface AppleClient {
    @GetMapping("/keys")
    fun applePublicKeys(): ApplePublicKeys?
}