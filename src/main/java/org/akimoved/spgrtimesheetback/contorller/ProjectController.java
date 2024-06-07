package org.akimoved.spgrtimesheetback.contorller;

import java.util.List;
import java.util.NoSuchElementException;

import org.akimoved.spgrtimesheetback.entity.Project;
import org.akimoved.spgrtimesheetback.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/project",
				produces = "application/json")
public class ProjectController {

	private final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping("")
	public List<Project> allProjects() {
		return projectService.getAll();
	}
	
	@SuppressWarnings("OptionalGetWithoutIsPresent")
    @GetMapping("/{pid}")
	public Project getProjectByPid(@PathVariable("pid") Integer pid) {
		try {
			return projectService.getById(pid).get();
		} catch (NoSuchElementException nsee) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found", nsee);
		} catch (IllegalArgumentException iae) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PID is invalid", iae);
		}
	}
}
