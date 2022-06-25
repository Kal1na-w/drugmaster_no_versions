package ua.od.atomspace.drugfiinder.dao;

import ua.od.atomspace.drugfiinder.dao.model.UserCredentials;

public interface UserCredentialsDao {
    void create(UserCredentials credentials);

    UserCredentials findByUsername(String username);
}
