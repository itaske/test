package com.example.testinggroudweb.patrick.model.region;
import lombok.Data;

import java.util.Map;

@Data
public class Region{
	private String code;
	private UpdatedAt updated_at;
	private String name;
	private CreatedAt created_at;
	private Map<String, Object> _id;
}
