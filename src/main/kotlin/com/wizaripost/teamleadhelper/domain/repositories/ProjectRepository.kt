package com.wizaripost.teamleadhelper.domain.repositories

import com.wizaripost.teamleadhelper.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository: JpaRepository<Project, Long> {
}