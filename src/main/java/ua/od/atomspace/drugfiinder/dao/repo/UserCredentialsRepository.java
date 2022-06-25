package ua.od.atomspace.drugfiinder.dao.repo;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import ua.od.atomspace.drugfiinder.dao.model.UserCredentials;

public interface UserCredentialsRepository {
    @SqlUpdate("INSERT INTO user_credentials (username, password) value (:username, :password)")
    void create(@BindBean UserCredentials userCredentials);

    @SqlQuery("SELECT * FROM user_credentials WHERE username = :username")
    @RegisterBeanMapper(UserCredentials.class)
    UserCredentials selectByUsername(@Bind String username);
}
