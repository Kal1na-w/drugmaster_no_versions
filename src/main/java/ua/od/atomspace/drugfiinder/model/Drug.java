package ua.od.atomspace.drugfiinder.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class Drug {

    private Long id;

    private String name;

    @Singular("purpose")
    private List<Symptom> purposeList;
}
