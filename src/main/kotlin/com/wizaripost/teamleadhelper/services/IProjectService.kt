package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO
import com.wizaripost.teamleadhelper.dto.ProjectUpdateForm

interface IProjectService {

    fun create(form: ProjectCreateForm): ProjectDTO

    fun update(form: ProjectUpdateForm): ProjectDTO

    fun getOne(id: Int): ProjectDTO

    fun getAll(): List<ProjectDTO>

    fun delete(id: Int)

//    fun saveOrCeate(form: ProjectCreateForm): ProjectDTO


}