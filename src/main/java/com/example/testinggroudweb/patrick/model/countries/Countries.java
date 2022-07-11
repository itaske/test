package com.example.testinggroudweb.patrick.model.countries;

import lombok.Data;

import java.util.Map;

@Data
public class Countries {
	private RegionsId regions_id;
	private String code;
	private UpdatedAt updated_at;
	private String name;
	private Map<String, Object> _id;
}