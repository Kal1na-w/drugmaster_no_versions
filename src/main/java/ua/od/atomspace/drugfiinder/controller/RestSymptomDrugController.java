package ua.od.atomspace.drugfiinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.od.atomspace.drugfiinder.model.Drug;
import ua.od.atomspace.drugfiinder.service.DrugPurposeService;

import java.util.List;

@RestController
public class RestSymptomDrugController {

    private DrugPurposeService drugPurposeService;

    @Autowired
    public RestSymptomDrugController(DrugPurposeService drugPurposeService) {
        this.drugPurposeService = drugPurposeService;
    }

//    @RequestMapping(path = "/drugs", method = RequestMethod.GET)
//    @ResponseStatus(code = HttpStatus.OK)
//    public Drug findPurposeByDrugName(@RequestParam String drugName){
//        return drugPurposeService.findDrugPurpose(drugName);
//    }

}
