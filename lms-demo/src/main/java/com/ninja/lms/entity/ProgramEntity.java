package com.ninja.lms.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_lms_program")
public class ProgramEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="program_id")
	private int programID;
	
	@Column(name="program_name", nullable = false, length = 512, unique = true)
	@NotBlank(message = "Product name cannot be blank")
	@Length(min = 5, max = 512, message = "Product name must be between 5-512 characters")
	@Pattern(regexp = "[a-zA-Z0–9-_]+", message="Not in proper format")
	private String programName;

	@Column(name="program_description")
	private String programDescription;
	@Column(name="program_status")
	private String programStatus;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "batch_program_id", referencedColumnName = "program_id")
//  @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<BatchEntity> batches = new ArrayList<BatchEntity>();
	
	public ProgramEntity() {}

	public ProgramEntity(int programID, String programName, String programDescription, 
			String programStatus, Set<BatchEntity> batches) {
		super();
		this.programID = programID;
		this.programName = programName;
		this.programDescription = programDescription;
		this.programStatus = programStatus;
	}

	public int getProgramID() {
		return programID;
	}

	public void setProgramID(int programID) {
		this.programID = programID;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public String getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}

	public List<BatchEntity> getBatches() {
		return batches;
	}

	
}
