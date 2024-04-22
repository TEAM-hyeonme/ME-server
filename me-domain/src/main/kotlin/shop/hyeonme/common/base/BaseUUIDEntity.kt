package shop.hyeonme.common.base

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.domain.Persistable
import java.util.UUID
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseUUIDEntity(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    @get:JvmName(name = "getIdentifier")
    open var id: UUID = UUID(0,0)
) : BaseTimeEntity(), Persistable<UUID> {
    override fun getId() = id

    override fun isNew(): Boolean {
        if(id == UUID(0,0)) {
            id = UUID.randomUUID()
            return false
        } else {
            return true
        }
    }
}
