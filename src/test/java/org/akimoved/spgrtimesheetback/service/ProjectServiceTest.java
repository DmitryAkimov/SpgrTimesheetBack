package org.akimoved.spgrtimesheetback.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.akimoved.spgrtimesheetback.data.ProjectRepository;
import org.akimoved.spgrtimesheetback.entity.Project;
import org.akimoved.spgrtimesheetback.service.impl.ProjectServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("testing ProjectService")
class ProjectServiceTest {

	@InjectMocks
	ProjectServiceImpl instance;
	
	@Mock
	private ProjectRepository projectRepo;
	
	@Test
	@DisplayName("triggering DAO to find all projects")
	void whenFindAllIsTriggered_thenSuccess() {
		when(projectRepo.findAll()).thenReturn(new ArrayList<>());
		instance.getAll();
		verify(projectRepo, times(1)).findAll();
	}
	
	@Test
	@DisplayName("finding all projects")
	void whenFindAllProjects_thenSuccess() {
		List<Project> projects = new ArrayList<>();
		projects.add(new Project());
		projects.add(new Project());
		projects.add(new Project());
		when(projectRepo.findAll()).thenReturn(projects);
		
		List<Project> retrievedProjects = instance.getAll();
		assertEquals(3, retrievedProjects.size(), "should get 3 projects");
	}
	
	@Test
	@DisplayName("finding project by id")
	void whenFindProjectById_thenSuccess() {
		when(projectRepo.findById(anyInt())).thenReturn(Optional.of(new Project()));
		
		Optional<Project> retrievedProject = instance.getById(1);
		assert(retrievedProject.isPresent());
		verify(projectRepo, times(1)).findById(anyInt());
	}
	
	@Test
	@DisplayName("throwing exception when pid is invalid")
	void whenIdInvalid_throwException() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> instance.getById(-1),
				"should throw exception if pid is invalid");
		assertEquals("PID -1 is invalid", e.getMessage());
	}
}
