package org.akimoved.spgrtimesheetback.data;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

import org.akimoved.spgrtimesheetback.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@DisplayName("testing ProjectRepository")
class ProjectRepositoryTest {

	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	TestEntityManager em;

	@Test
	@DisplayName("saving project")
	void givenNewProject_whenSave_thenSuccess() {
		Project newProject = new Project("Test Project");
		Project insertedProject = repo.save(newProject);
		assertThat(em.find(Project.class, insertedProject.getId()))
			.as("saved project must be equal to original")
			.isEqualTo(newProject);
	}
	
	@Test
	@DisplayName("updating project title")
	void givenProjectCreated_whenUpdate_thenSuccess() {
		Project newProject = new Project("Old Name");
		em.persist(newProject);
		
		String newTitle = "New Name";
		newProject.setTitle(newTitle);
		repo.save(newProject);
		
		assertThat(em.find(Project.class, newProject.getId()).getTitle())
			.as("should return updated title")
			.isEqualTo(newTitle);
	}
	
	@Test
	@DisplayName("finding project by id")
	void givenProjectCreated_whenFindById_thenSuccess() {
	    Project newProject = new Project("Test Project 1");
	    em.persist(newProject);
	    Optional<Project> retrievedProject = repo.findById(newProject.getId());
	    assertThat(retrievedProject)
	    	.as("should find stored project")
	    	.contains(newProject);
	}
	
	@Test
	@DisplayName("finding several projects by title containing")
	void givenProjectsCreated_whenFindByNameContaining_thenSuccess() {
		Project firstProject = new Project("Test Project 1");
		Project secondProject = new Project("Test Project 2");
		em.persist(firstProject);
		em.persist(secondProject);
		
		Iterable<Project> retrievedProjects = repo.findByTitleContaining("Test");
		assertThat(retrievedProjects)
			.as("should return projects with titles containing 'Test'")
			.contains(firstProject, secondProject);
	}
	
	@Test
	@DisplayName("deleting project")
	void givenProjectCreated_whenDelete_thenSuccess() {
		Project newProject = new Project("Test Project");
		em.persist(newProject);
		repo.delete(newProject);
		assertThat(em.find(Project.class, newProject.getId()))
			.as("should return no projects")
			.isNull();
	}
}
