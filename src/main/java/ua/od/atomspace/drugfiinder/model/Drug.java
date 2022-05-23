package ua.od.atomspace.drugfiinder.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Drug {

    private Long id;

    private String name;

    private Timestamp created_at;

    @Singular("purpose")
    private List<Symptom> purposeList;
}
