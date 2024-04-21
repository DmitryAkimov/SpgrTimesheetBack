package org.akimoved.spgrtimesheetback.contorller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.akimoved.spgrtimesheetback.entity.Project;
import org.akimoved.spgrtimesheetback.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class ProjectControllerTest {

	@MockBean
	private ProjectService service;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void givenProjects_whenGetAllProjects_thenReturnJsonArray() throws Exception {
		Project project = new Project("Test Project");
		List<Project> list = new ArrayList<Project>();
		list.add(project);
		
		when(service.getAll()).thenReturn(list);
		
		mvc.perform(get("/api/project")).andExpectAll(
				status().isOk(),
				content().contentType(MediaType.APPLICATION_JSON),
				jsonPath("$", hasSize(1))
				);
		
		verify(service, times(1)).getAll();
	}
}
