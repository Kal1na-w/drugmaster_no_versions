package ua.od.atomspace.drugfiinder.service;

import ua.od.atomspace.drugfiinder.dao.model.Drug;

import java.util.List;

public interface DrugService {

    List<Drug> readAll();

    Drug read(long id);

    Drug createDrug(Drug drug);

    Drug updateDrug(Long id, Drug drug);

    void deleteDrug(long id);

}
