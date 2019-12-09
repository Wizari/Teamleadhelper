package com.wizaripost.teamleadhelper.controller

import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.services.IProjectService
import com.wizaripost.teamleadhelper.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class ProjectController(val projectService: ProjectService) {


    @GetMapping("/projects/list")
    fun getProjectsList(model: Model): String {
        val allProjects = this.projectService.getAll()
        model.addAttribute("projects", allProjects)
        return "projects/list"
    }

    @GetMapping("/projects/edit/{id}")
    fun getEditPage(@PathVariable(required = true) id: Int, model: Model): String {
        val project = this.projectService.getOne(id)
        model.addAttribute("project", project)
        return "projects/edit"
    }

    @GetMapping("/projects/create")
    fun getCreatePage(model: Model): String {
        model.addAttribute("project", ProjectCreateForm("", ""))
        return "projects/edit"
    }

    @PostMapping("/projects/edit")
    fun postEditPage(@ModelAttribute(name = "project") form: ProjectCreateForm): String {
        this.projectService.create(form)
        return "redirect:/projects/list"
    }



}
