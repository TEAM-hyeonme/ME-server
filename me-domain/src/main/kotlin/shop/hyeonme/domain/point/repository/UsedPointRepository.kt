package shop.hyeonme.domain.point.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.point.entity.UsedPointEntity

interface UsedPointRepository : CrudRepository<UsedPointEntity, Long>