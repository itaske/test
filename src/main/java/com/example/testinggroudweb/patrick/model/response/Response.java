package com.example.testinggroudweb.patrick.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Patrick Udochukwu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String reference;
    private String country;
    private String cedants;
    private String validationStatus;
    private String confirmationStatus;
    private String publicationDate;
    private String branche;
    private double calculatedREC;

    public Response(String reference, String country, String cedants, String validationStatus, String confirmationStatus, String publicationDate, String branche) {
        this.reference = reference;
        this.country = country;
        this.cedants = cedants;
        this.validationStatus = validationStatus;
        this.confirmationStatus = confirmationStatus;
        this.publicationDate = publicationDate;
        this.branche = branche;
    }

    public void setCalculatedREC(double premium_ht) {
        double result =  (premium_ht * 36/100) + getCalculatedREC();
        this.calculatedREC = result;
    }
}
