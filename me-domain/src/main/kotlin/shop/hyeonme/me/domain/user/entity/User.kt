package shop.hyeonme.me.domain.user.entity

import shop.hyeonme.me.common.base.BaseUUIDEntity
import shop.hyeonme.me.common.enums.Role
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class User (
    @Column(columnDefinition = "VARCHAR(8)", nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5)", nullable = false)
    val role: Role,

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    val email: String
) : BaseUUIDEntity()