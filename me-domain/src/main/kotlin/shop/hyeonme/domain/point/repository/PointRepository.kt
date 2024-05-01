package shop.hyeonme.domain.point.repository

import org.springframework.data.repository.CrudRepository
import shop.hyeonme.domain.point.entity.PointEntity

interface PointRepository : CrudRepository<PointEntity, Long>