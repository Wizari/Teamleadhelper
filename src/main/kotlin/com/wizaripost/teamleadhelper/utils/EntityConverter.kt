package com.wizaripost.teamleadhelper.utils

import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.dto.ProjectDTO

fun convertTo(source: Project): ProjectDTO{
    return ProjectDTO(
            source.id,
            source.code,
            source.name
    )
}

fun convertTo(source: ProjectDTO): Project{
    return Project(
            source.id,
            source.code,
            source.name
    )
}