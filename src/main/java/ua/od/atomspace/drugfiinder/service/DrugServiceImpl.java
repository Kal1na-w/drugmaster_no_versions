package ua.od.atomspace.drugfiinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.od.atomspace.drugfiinder.dao.DrugDao;
import ua.od.atomspace.drugfiinder.dao.model.Drug;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    private final DrugDao drugDao;

    @Autowired
    public DrugServiceImpl(DrugDao drugDao) {
        this.drugDao = drugDao;
    }

    @Override
    public List<Drug> readAll() {
        return drugDao.readAll();
    }

    @Override
    public Drug read(long id) {
        return drugDao.read(id);
    }

    @Override
    public Drug createDrug(Drug drug) {
        return drugDao.createDrug(drug);
    }

    @Override
    public Drug updateDrug(Long id, Drug drug) {
        return drugDao.updateDrug(id, drug);
    }

    @Override
    public void deleteDrug(long id) {
        drugDao.deleteDrug(id);
    }
}
