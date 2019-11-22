package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO

interface IProjectService {

    fun create(form: ProjectCreateForm): ProjectDTO

    fun update(project: ProjectDTO): ProjectDTO


}