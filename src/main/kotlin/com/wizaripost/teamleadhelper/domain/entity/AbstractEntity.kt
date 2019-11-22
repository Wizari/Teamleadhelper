package com.wizaripost.teamleadhelper.domain.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractEntity<T>(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: T? = null
) {
}