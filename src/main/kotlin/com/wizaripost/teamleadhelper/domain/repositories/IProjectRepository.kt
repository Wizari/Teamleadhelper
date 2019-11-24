package com.wizaripost.teamleadhelper.domain.repositories

import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO
import org.springframework.data.jpa.repository.JpaRepository

interface IProjectRepository: JpaRepository<Project, Int> {

    fun findByNameAndCodeOrNull(code: String?, name: String?): Project

}