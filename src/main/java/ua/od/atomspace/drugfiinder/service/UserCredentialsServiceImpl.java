package ua.od.atomspace.drugfiinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.od.atomspace.drugfiinder.dao.UserCredentialsDao;
import ua.od.atomspace.drugfiinder.dao.model.UserCredentials;
import ua.od.atomspace.drugfiinder.dto.UserCredentialsDto;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsDao userCredentialsDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserCredentialsServiceImpl(UserCredentialsDao userCredentialsDao, PasswordEncoder passwordEncoder) {
        this.userCredentialsDao = userCredentialsDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(UserCredentialsDto dto) {
        UserCredentials userCredentials = buildUserCredentials(dto);
        userCredentialsDao.create(userCredentials);
    }

    @Override
    public UserCredentials findByUsername(String username) {
        return userCredentialsDao.findByUsername(username);
    }

    private UserCredentials buildUserCredentials(UserCredentialsDto dto) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setId(dto.getId());
        userCredentials.setUsername(dto.getUsername());
        userCredentials.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userCredentials;
    }

}
