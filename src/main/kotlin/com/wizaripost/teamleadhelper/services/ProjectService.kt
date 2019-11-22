package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.domain.repositories.IProjectRepository
import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO
import com.wizaripost.teamleadhelper.utils.convertTo
import org.springframework.stereotype.Service

@Service
class ProjectService(val repository: IProjectRepository) : IProjectService{

    override fun create(form: ProjectCreateForm): ProjectDTO {
        val entity = this.repository.save(Project(form.code, form.name))
        return convertTo(entity)
    }

    override fun update(project: ProjectDTO): ProjectDTO {
        val entity = this.repository.save(convertTo(project))
        return convertTo(entity)
    }


}


