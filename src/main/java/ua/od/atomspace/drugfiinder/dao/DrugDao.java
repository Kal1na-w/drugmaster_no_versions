package ua.od.atomspace.drugfiinder.dao;

import ua.od.atomspace.drugfiinder.dao.model.Drug;

import java.util.List;

public interface DrugDao {
    List<Drug> readAll();

    Drug read(long id);

    Drug createDrug(Drug drug);

    Drug updateDrug(Long id, Drug drug);

    void deleteDrug(long id);
}
