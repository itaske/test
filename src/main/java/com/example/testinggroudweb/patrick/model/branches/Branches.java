package com.example.testinggroudweb.patrick.model.branches;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
//@Entity
public class Branches{

	private String code;

	private UpdatedAt updated_at;

	private String name;

	private List<String> alias;

	private CreatedAt created_at;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Map<String, Object> _id;

	private String is_parent;

	private String type;

private Map<String, Object> parent_branch_id;

	private String status;
}