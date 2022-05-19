package ua.od.atomspace.drugfiinder.service;

import ua.od.atomspace.drugfiinder.model.Drug;

public interface DrugPurposeService {
    Drug findDrugPurpose(String drugName);
}
