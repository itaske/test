package com.example.testinggroudweb.patrick.controller;

import com.example.testinggroudweb.patrick.service.RECRiskService;
import com.example.testinggroudweb.patrick.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.spi.SoundbankReader;
import java.util.List;
import java.util.Set;

/**
 * @author Patrick Udochukwu
 */

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    @Autowired
    private RECRiskService recRiskService;

    @GetMapping("records/")
    public Set<Response> getResults(@RequestParam String reference, @RequestParam String validationStatus, @RequestParam String confirmationStatus, @RequestParam String publicationDate) {

        return recRiskService.searchRec(reference, validationStatus, confirmationStatus, publicationDate);
    }

    @GetMapping("id/{id}")
    public List<Response> getRecordById(@PathVariable("id") String reference){
        return recRiskService.findCedantsRec(reference);
    }
}
