package ua.od.atomspace.drugfiinder.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.od.atomspace.drugfiinder.exception.NotFoundException;
import ua.od.atomspace.drugfiinder.model.Drug;
import ua.od.atomspace.drugfiinder.model.Symptom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DrugDaoImpl implements DrugDao {

    private List<Drug> drugs = new ArrayList<>(List.of(
            Drug.builder()
                    .id(1L)
                    .name("Noshpa")
                    .purpose(Symptom.STOMACH)
                    .build(),
            Drug.builder()
                    .id(2L)
                    .name("Aspirin")
                    .purpose(Symptom.HEADACHE)
                    .purpose(Symptom.TOOTHACHE)
                    .build())
    );

    @Override
    public List<Drug> readAll() {
        return drugs;
    }

    @Override
    public Drug read(long id) {
        return drugs.stream()
                .filter(drug -> drug.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Drug NOT_FOUND"));
    }

    @Override
    public Drug createDrug(Drug drug) {
        Long maxId = drugs.stream()
                .max((d1, d2) -> {
                    if (d1.getId() > d2.getId()) {
                        return 1;
                    } else if (d1.getId().equals(d2.getId())) {
                        return 0;
                    }
                    return -1;
                })
                .map(Drug::getId)
                .orElseThrow();
        drug.setId(maxId + 1);
        drugs.add(drug);
        return drug;
    }

    @Override
    public Drug updateDrug(Long id, Drug drug) {
        drugs = drugs.stream()
                .map(d -> {
                    if (d.getId().equals(id)) {
                        return drug;
                    }
                    return d;
                })
                .collect(Collectors.toList());
        return drug;
    }

    @Override
    public void deleteDrug(long id) {
        drugs = drugs.stream()
                .map(d -> {
                    if (d.getId().equals(id)) {
                        return null;
                    }
                    return d;
                })
                .collect(Collectors.toList());
    }
}
