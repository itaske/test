package com.example.testinggroudweb.patrick.model.slipspremium;

import java.util.List;
import java.util.Map;

import com.example.testinggroudweb.patrick.model.slipspremium.NonBlockingCasesItem;
import lombok.Data;

@Data
public class Warnings{

	private List<NonBlockingCasesItem> non_blocking_cases;

	private List<Object> critical_cases;

	private List<NoIssuesCasesItem> no_issues_cases;

	private Map<String, Object> premium_slip_case_check;
}