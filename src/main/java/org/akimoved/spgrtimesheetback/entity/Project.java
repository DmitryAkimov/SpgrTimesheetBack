package org.akimoved.spgrtimesheetback.entity;

import java.time.Instant;

import org.hibernate.type.NumericBooleanConverter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbProjects")
@Data
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Setter(AccessLevel.NONE)
	private Integer id;
	
	@NotNull
	private String title;
	
	private String cipher;
	
	@Convert(converter = NumericBooleanConverter.class)
	private boolean hasBudget;
	
	@Basic
	private Instant start;
	
	@Basic
	private Instant finish;
	
	@Column(name = "status_id")
	private int statusCode;
	
	@Column(name = "ChiefEid")
	private String chiefId;
	
	@Column(name = "ManagerEid")
	private String managerId;
	
	@Column(name = "class")
	private int classCode;

	public Project(@NotNull String title) {
		this.title = title;
	}
	
	
}
