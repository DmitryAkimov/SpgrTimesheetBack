package org.akimoved.spgrtimesheetback.service.impl;

import java.util.List;
import java.util.Optional;

import org.akimoved.spgrtimesheetback.data.ProjectRepository;
import org.akimoved.spgrtimesheetback.entity.Project;
import org.akimoved.spgrtimesheetback.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepo;
	
	public ProjectServiceImpl(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}

	@Override
	public Optional<Project> getById(int id) {
		if (id < 0) throw new IllegalArgumentException("PID " + id + " is invalid");
		return projectRepo.findById(id);
	}

	@Override
	public List<Project> getAll() {
		return projectRepo.findAll();
	}

}
