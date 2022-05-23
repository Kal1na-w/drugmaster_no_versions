package ua.od.atomspace.drugfiinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.od.atomspace.drugfiinder.dao.SymptomDrugDao;
import ua.od.atomspace.drugfiinder.model.Drug;
import ua.od.atomspace.drugfiinder.model.Symptom;

import java.util.List;

@Service
public class DrugPurposeServiceImpl implements DrugPurposeService {
    @Override
    public Drug findDrugPurpose(String drugName) {
        return null;
    }

//    private SymptomDrugDao symptomDrugDao;
//
//    @Autowired
//    public DrugPurposeServiceImpl(SymptomDrugDao symptomDrugDao) {
//        this.symptomDrugDao = symptomDrugDao;
//    }
//
//    @Override
//    public Drug findDrugPurpose(String drugName) {
//        List<Symptom> purposeByDrugName = symptomDrugDao.findPurposeByDrugName(drugName);
//        return Drug.builder()
//                .purposeList(purposeByDrugName)
//                .name(drugName)
//                .build();
//    }
}
