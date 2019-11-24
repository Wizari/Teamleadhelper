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

    override fun getOne(id: Int): ProjectDTO {
        return convertTo(this.repository.getOne(id))
    }

    override fun getAll(): List<ProjectDTO> {
        return this.repository.findAll().map { project -> convertTo(project) }
    }

    override fun delete(id: Int) {
        this.repository.deleteById(id)
    }

//    override fun saveOrCeate(form: ProjectCreateForm): ProjectDTO {
//        val entity = this.repository.findByNameAndCodeOrNull(form)
//        return if (entity.id == null) {
//            convertTo(this.repository.save(Project(entity.code!!, entity.name!!)))
//        } else {
//            convertTo(this.repository.save(entity))
//        }
//    }
}


