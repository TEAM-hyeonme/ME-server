package shop.hyeonme.me.common.base

import org.springframework.data.domain.Persistable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseLongEntity(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    open var id: Long = 0L
) : BaseTimeEntity(), Persistable<Long> {
    override fun getId() = id

    override fun isNew() = id == 0L
}
