package com.appstude.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;

import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppRole implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String roleName;
	
}
