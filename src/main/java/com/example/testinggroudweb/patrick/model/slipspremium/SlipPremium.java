package com.example.testinggroudweb.patrick.model.slipspremium;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SlipPremium {

    private String file_url;

    private String update_progress;

    private Map<String, Object> created_at;

    private String confirmation_date;

    private String net_amount_total;

    private String reference;

    private Map<String, Object> updated_at = new HashMap<>();

    private String warnings_saved;

    private String is_paid;

    private String invoice_premium_total;

    private String slip_type;

    private String edited_period;

    private String approval_status;

//	private Warnings warnings;

    private Map<String, Object> cedants_id = new HashMap<>();

    private Map<String, Object> reinsurances_id = new HashMap<>();

    private Map<String, Object> user_cedant_id = new HashMap<>();

    private String commission_refunded_total;

    private String update_status;

    private String confirmation_status;

    private Map<String, Object> cedants_type_id = new HashMap<>();

    private Map<String, Object> _id = new HashMap<>();

    private String validation_status;

    private String published_date;

    private String validation_date;
}