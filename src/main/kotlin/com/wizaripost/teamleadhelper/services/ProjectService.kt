package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.domain.repositories.ProjectRepository

class ProjectService(repository: ProjectRepository) : IProjectService{

    override fun getOne(id: Int): Project {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(t: Project): Project {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}