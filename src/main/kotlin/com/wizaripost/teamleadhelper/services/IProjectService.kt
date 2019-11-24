package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO

interface IProjectService {

    fun create(form: ProjectCreateForm): ProjectDTO

    fun update(project: ProjectDTO): ProjectDTO

    fun getOne(id: Int): ProjectDTO

    fun getAll(): List<ProjectDTO>

    fun delete(id: Int)

//    fun saveOrCeate(form: ProjectCreateForm): ProjectDTO


}