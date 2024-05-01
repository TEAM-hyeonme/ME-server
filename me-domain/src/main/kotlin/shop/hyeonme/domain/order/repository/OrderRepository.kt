package shop.hyeonme.domain.order.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.order.entity.OrderEntity

interface OrderRepository : CrudRepository<OrderEntity, Long>