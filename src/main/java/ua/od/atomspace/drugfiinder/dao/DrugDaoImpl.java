package ua.od.atomspace.drugfiinder.dao;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.od.atomspace.drugfiinder.dao.repo.DrugRepository;
import ua.od.atomspace.drugfiinder.dao.model.Drug;

import java.util.List;

@Component
public class DrugDaoImpl implements DrugDao {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugDaoImpl(Jdbi jdbi) {
        this.drugRepository = jdbi.onDemand(DrugRepository.class);
    }

    @Override
    public List<Drug> readAll() {
        return drugRepository.selectAll();
    }

    @Override
    public Drug read(long id) {
        return drugRepository.selectById(id);
    }

    @Override
    public Drug createDrug(Drug drug) {
        drugRepository.insert(drug);
        return drugRepository.findByName(drug.getName());
    }

    @Override
    public Drug updateDrug(Long id, Drug drug) {
        drugRepository.update(id, drug);
        return drugRepository.selectById(id);
    }

    @Override
    public void deleteDrug(long id) {
        drugRepository.delete(id);
    }
}
