package com.example.myhome.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bno")
	@SequenceGenerator(sequenceName = "bno", name="bno", allocationSize = 1)
	@Column(name = "bno")
	private Long bno;
	
	private String title;
	private String content;
	private Date regdate;

	

}
