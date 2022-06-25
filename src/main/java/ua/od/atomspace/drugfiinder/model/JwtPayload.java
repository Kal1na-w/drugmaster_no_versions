package ua.od.atomspace.drugfiinder.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtPayload {
    private String username;

    public enum Claims {
        USERNAME
    }
}
