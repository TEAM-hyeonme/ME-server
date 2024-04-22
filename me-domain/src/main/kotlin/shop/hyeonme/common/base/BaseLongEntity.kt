package shop.hyeonme.common.base

import org.springframework.data.domain.Persistable
import javax.persistence.*

@MappedSuperclass
abstract class BaseLongEntity(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    open val id: Long = 0L
) : BaseTimeEntity(), Persistable<Long> {
    override fun getId() = id

    override fun isNew() = id == 0L
}
