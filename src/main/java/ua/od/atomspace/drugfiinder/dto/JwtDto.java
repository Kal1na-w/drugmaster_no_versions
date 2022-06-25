package ua.od.atomspace.drugfiinder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtDto {
    private String jwt;
}
