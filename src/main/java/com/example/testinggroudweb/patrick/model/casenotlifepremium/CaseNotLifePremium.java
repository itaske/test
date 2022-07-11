package com.example.testinggroudweb.patrick.model.casenotlifepremium;

import lombok.Data;

import java.util.Map;

@Data
public class CaseNotLifePremium{

	private String paid_commission;

	private String part_cedant_coass;

	private String branch;

	private String insured_capital;

	private String prime_net_ceded;

	private String date_transaction;

	private Object invoiced_premium;

	private Object sub_branches_id;

	private String policy_number;

	private UpdatedAt updated_at;

	private String premium_ceded;

	private String case_validation_status;

	private SlipesPrimeId slipes_prime_id;

	private BranchesId branches_id;

	private String deadline;

	private String nature_risque_id;

	private CedantsId cedants_id;

	private String date_effective;

	private String commission_cession;

	private String active_status;

	private String case_variant;

	private Map<String, Object> _id;

	private Object net_amount;

	private String category;

	private Object commission_refunded;

	private double premium_ht;
}