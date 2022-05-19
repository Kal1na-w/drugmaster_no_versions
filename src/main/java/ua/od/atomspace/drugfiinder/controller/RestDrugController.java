package ua.od.atomspace.drugfiinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.od.atomspace.drugfiinder.model.Drug;
import ua.od.atomspace.drugfiinder.service.DrugService;

import java.util.List;

@RestController
@RequestMapping(path = "/drugs")
public class RestDrugController {

    private DrugService drugService;


    @Autowired
    public RestDrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Drug> readAll() {
        return drugService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Drug read(@PathVariable Long id) {
        return drugService.read(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Drug create(@RequestBody Drug drug) {
        return drugService.createDrug(drug);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Drug update(@PathVariable Long id, @RequestBody Drug drug) {
        return drugService.updateDrug(id, drug);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        drugService.deleteDrug(id);
    }

}
