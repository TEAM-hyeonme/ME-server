package shop.hyeonme.domain.user.entity

import shop.hyeonme.common.base.BaseUUIDEntity
import shop.hyeonme.domain.auth.model.Role
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class UserEntity (
    @Column(columnDefinition = "VARCHAR(8)", nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5)", nullable = false)
    val role: Role,

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    val email: String
) : BaseUUIDEntity()