package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.domain.repositories.IProjectRepository
import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO
import com.wizaripost.teamleadhelper.dto.ProjectUpdateForm
import com.wizaripost.teamleadhelper.exception.EntityNotFoundException
import com.wizaripost.teamleadhelper.utils.convertTo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProjectService(val repository: IProjectRepository) : IProjectService{

    override fun create(form: ProjectCreateForm): ProjectDTO {
        val entity = this.repository.save(Project(form.code, form.name))
        return convertTo(entity)
    }

    override fun update(form: ProjectUpdateForm): ProjectDTO {
        val project: Project
        synchronized(this){
            project = (this.repository.findByIdOrNull(form.id) ?: throw EntityNotFoundException())
                    .apply {
                        code = form.code
                        name = form.name
                    }
            this.repository.save(project)
        }
        return convertTo(project)
    }

    override fun getOne(id: Int): ProjectDTO {
        return convertTo(this.repository.findByIdOrNull(id) ?: throw EntityNotFoundException())
    }

    override fun getAll(): List<ProjectDTO> {
        return this.repository.findAll().map { project -> convertTo(project) }
    }

    override fun delete(id: Int) {
        synchronized(this){
            this.repository.deleteById(id)
        }

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


