package com.example.testinggroudweb.patrick.model.groupscedant;

import lombok.Data;

import java.util.Map;

@Data
public class GroupsCedant{

	private UpdatedAt updated_at;

	private String name;

	private CreatedAt created_at;

	private Map<String, Object> _id;
}