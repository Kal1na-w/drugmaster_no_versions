package ua.od.atomspace.drugfiinder.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCredentials {
    private Long id;
    private String username;
    private String password;
}
