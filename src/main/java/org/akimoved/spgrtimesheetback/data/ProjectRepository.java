package org.akimoved.spgrtimesheetback.data;

import org.akimoved.spgrtimesheetback.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Iterable<Project> findByTitleContaining(String title);
	
}
