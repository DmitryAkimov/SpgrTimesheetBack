package org.akimoved.spgrtimesheetback.entity;

import java.time.Instant;

import org.akimoved.spgrtimesheetback.data.converter.BooleanShortConverter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.type.NumericBooleanConverter;

import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbProjects")
@Data
@NoArgsConstructor
public class Project {
	
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Setter(AccessLevel.NONE)
	private Integer id;
	
	@NotNull
	private String title;
	
	@Column(length=4,
			columnDefinition="NCHAR")
	@Size(min=4, max=4)
	@Nationalized
	private String cipher;
	
	@Column(name="has_budget")
	@Convert(converter = BooleanShortConverter.class)
	private boolean hasBudget;
	
	@Basic
	private Instant start;
	
	@Basic
	private Instant finish;
	
	@Column(name = "status_id",
			nullable = true)
	private Integer statusCode;
	
	@Column(name = "ChiefEid")
	private String chiefId;
	
	@Column(name = "ManagerEid")
	private String managerId;
	
	@Column(name = "class")
	private Integer classCode;

	public Project(@NotNull String title) {
		this.title = title;
	}
	
	
}
