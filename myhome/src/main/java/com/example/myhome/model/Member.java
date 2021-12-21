package com.example.myhome.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Member {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mno")
	@SequenceGenerator(sequenceName = "mno", name="mno", allocationSize = 1)
	@Column(name = "mno")
	private Long mno;
	
	private String id;
	private String pw;
	private String enabled;
	
    @ManyToMany
    @JoinTable(name = "member_role",
        joinColumns = @JoinColumn(name = "mno"),
        inverseJoinColumns = @JoinColumn(name = "rno")
    )
    private List<Role> roles = new ArrayList<>();
}
