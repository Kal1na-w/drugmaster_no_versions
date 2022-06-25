package ua.od.atomspace.drugfiinder.service;

import ua.od.atomspace.drugfiinder.dao.model.Drug;

public interface DrugPurposeService {
    Drug findDrugPurpose(String drugName);
}
