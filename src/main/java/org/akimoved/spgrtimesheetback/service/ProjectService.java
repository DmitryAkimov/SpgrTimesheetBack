package org.akimoved.spgrtimesheetback.service;

import java.util.List;
import java.util.Optional;

import org.akimoved.spgrtimesheetback.entity.Project;

public interface ProjectService {
	Optional<Project> getById(int id);
	List<Project> getAll();
}
