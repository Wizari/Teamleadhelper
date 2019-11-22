package com.wizaripost.teamleadhelper.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "project")
class Project(
        id: Int?,
        @Column(name = "Code")
        var code: String?,
        @Column(name = "Name")
        var name: String?
) : AbstractEntity<Int>(id) {

    constructor(code: String, name: String): this(null, code, name)

}