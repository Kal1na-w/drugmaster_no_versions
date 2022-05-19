package ua.od.atomspace.drugfiinder.dao;

import ua.od.atomspace.drugfiinder.model.Symptom;

import java.util.List;

public interface SymptomDrugDao {
    List<Symptom> findPurposeByDrugName(String drugName);
}
