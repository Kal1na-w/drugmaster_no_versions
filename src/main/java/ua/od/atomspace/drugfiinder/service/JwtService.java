package ua.od.atomspace.drugfiinder.service;

import ua.od.atomspace.drugfiinder.model.JwtPayload;

public interface JwtService {
    JwtPayload decode(String token);

    String encode(JwtPayload payload);
}
