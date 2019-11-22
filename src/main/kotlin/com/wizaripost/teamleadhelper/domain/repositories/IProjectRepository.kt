package com.wizaripost.teamleadhelper.domain.repositories

import com.wizaripost.teamleadhelper.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface IProjectRepository: JpaRepository<Project, Long> {
}