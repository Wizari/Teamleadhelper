package com.wizaripost.teamleadhelper.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping
    fun getIndexPage(): String {
        return "index"
    }

}