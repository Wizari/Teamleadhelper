package com.wizaripost.teamleadhelper.services

import com.wizaripost.teamleadhelper.TeamLeadHelperApplicationTests
import com.wizaripost.teamleadhelper.domain.entity.Project
import com.wizaripost.teamleadhelper.domain.repositories.IProjectRepository
import com.wizaripost.teamleadhelper.dto.ProjectCreateForm
import com.wizaripost.teamleadhelper.dto.ProjectDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest(classes = [TeamLeadHelperApplicationTests::class])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
internal class ProjectServiceTest {

    @Autowired
    lateinit var projectRepository: IProjectRepository

    @Autowired
    lateinit var projectService: IProjectService

    @Test
    fun instanceTest() {
        assertThat(this.projectService).isNotNull
        assertThat(this.projectRepository).isNotNull
    }

    @Test
    fun createTest() {
        val form = this.createProjectCreateForm()

        val result = this.projectService.create(form)
        assertThat(result.id).isNotNull()
        assertThat(result.code).isEqualTo("code")
        assertThat(result.name).isEqualTo("name")
    }

    @Test
    fun updateTest() {
        val form = this.createProjectCreateForm()
       this.projectService.create(form)
        val entity = ProjectDTO(1, "code-mod", "name-mod")

        val result = this.projectService.update(entity)
        assertThat(result.id).isEqualTo(1)
        assertThat(result.code).isEqualTo("code-mod")
        assertThat(result.name).isEqualTo("name-mod")
    }

    @BeforeEach
    fun setUp() {
    }

    fun createProjectCreateForm(): ProjectCreateForm {
        return ProjectCreateForm(
                "code",
                "name"
        )
    }
}