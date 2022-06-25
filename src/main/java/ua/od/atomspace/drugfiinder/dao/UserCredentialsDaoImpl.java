package ua.od.atomspace.drugfiinder.dao;

import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Component;
import ua.od.atomspace.drugfiinder.dao.model.UserCredentials;
import ua.od.atomspace.drugfiinder.dao.repo.UserCredentialsRepository;

@Component
public class UserCredentialsDaoImpl implements UserCredentialsDao {
    private final UserCredentialsRepository userCredentialsRepository;

    public UserCredentialsDaoImpl(Jdbi jdbi) {
        this.userCredentialsRepository = jdbi.onDemand(UserCredentialsRepository.class);
    }

    @Override
    public void create(UserCredentials credentials) {
        userCredentialsRepository.create(credentials);
    }

    @Override
    public UserCredentials findByUsername(String username) {
        return userCredentialsRepository.selectByUsername(username);
    }
}
