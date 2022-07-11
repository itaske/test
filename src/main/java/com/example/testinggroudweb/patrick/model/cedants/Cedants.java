package com.example.testinggroudweb.patrick.model.cedants;

import lombok.Data;

import java.util.Map;

@Data
public class Cedants {

	private String benefit_percentage;

	private String code;

	private GroupsCedantsId groups_cedants_id;

	private CurrenciesId currencies_id;

	private RegionId region_id;

	private CreatedAt created_at;

	private TypesCedantsId types_cedants_id;

	private ReinsurancesId reinsurances_id;

	private String color1;

	private String color2;

	private Map<String, Object> countries_id;

	private UpdatedAt updated_at;

	private String contact;

	private String estimation_type;

	private String name;

	private String logo;

	private Map<String, Object> _id;

	private String email;
}