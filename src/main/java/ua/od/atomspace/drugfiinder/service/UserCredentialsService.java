package ua.od.atomspace.drugfiinder.service;

import ua.od.atomspace.drugfiinder.dao.model.UserCredentials;
import ua.od.atomspace.drugfiinder.dto.UserCredentialsDto;

public interface UserCredentialsService {

    void create(UserCredentialsDto dto);

    UserCredentials findByUsername(String username);

}
