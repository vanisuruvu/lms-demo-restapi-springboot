package com.ninja.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="tbl_lms_batch")
public class BatchEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="batch_id")
	private int batchID;
	
	@Column(name="batch_name")
	private String batchName;
	@Column(name="batch_description")
	private String batchDescription;
	@Column(name="batch_status")
	private String batchStatus;
	@Column(name="batch_program_id")
	private String batchProgramID;
	@Column(name="batch_no_of_classes")
	private String batchNoOfClasses;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="batch_program_id", referencedColumnName = "program_id", insertable = false, updatable = false)
	@JsonIgnore
	private ProgramEntity programEntity;
	
	
	public BatchEntity() {}

//	public BatchEntity(int batchID, String batchName, String batchDescription, String batchStatus,
//			String batchProgramID, String batchNoOfClasses, int programID) {
//		super();
//		this.batchID = batchID;
//		this.batchName = batchName;
//		this.batchDescription = batchDescription;
//		this.batchStatus = batchStatus;
//		this.batchProgramID = batchProgramID;
//		this.batchNoOfClasses = batchNoOfClasses;
//		this.programEntity = new ProgramEntity(programID, "", "", "");
//	}

	public BatchEntity(int batchID, String batchName, String batchDescription, String batchStatus,
			String batchProgramID, String batchNoOfClasses) {
		super();
		this.batchID = batchID;
		this.batchName = batchName;
		this.batchDescription = batchDescription;
		this.batchStatus = batchStatus;
		this.batchProgramID = batchProgramID;
		this.batchNoOfClasses = batchNoOfClasses;
		
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchDescription() {
		return batchDescription;
	}

	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}

	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getBatchProgramID() {
		return batchProgramID;
	}

	public void setBatchProgramID(String batchProgramID) {
		this.batchProgramID = batchProgramID;
	}

	public String getBatchNoOfClasses() {
		return batchNoOfClasses;
	}

	public void setBatchNoOfClasses(String batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}

	public ProgramEntity getProgramEntity() {
		return programEntity;
	}

	public void setProgramEntity(ProgramEntity programEntity) {
		this.programEntity = programEntity;
	}
	
	
	
}
