package ua.od.atomspace.drugfiinder.dao;

import org.springframework.stereotype.Repository;
import ua.od.atomspace.drugfiinder.exception.NotFoundException;
import ua.od.atomspace.drugfiinder.model.Drug;
import ua.od.atomspace.drugfiinder.model.Symptom;

import java.util.List;

@Repository
public class SymptomDrugDaoInMemory implements SymptomDrugDao {

    private List<Drug> drugs = List.of(
            Drug.builder()
                    .name("Noshpa")
                    .purpose(Symptom.STOMACH)
                    .build(),
            Drug.builder()
                    .name("Aspirin")
                    .purpose(Symptom.HEADACHE)
                    .purpose(Symptom.TOOTHACHE)
                    .build()
    );

    @Override
    public List<Symptom> findPurposeByDrugName(String drugName) {
        return drugs.stream()
                .filter(drug -> drug.getName().equals(drugName))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Drug NOT_FOUND"))
                .getPurposeList();
    }
}
