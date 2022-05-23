package ua.od.atomspace.drugfiinder.dao.repo;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.context.annotation.Bean;
import ua.od.atomspace.drugfiinder.model.Drug;

import java.util.List;

public interface DrugRepository {

    @SqlQuery("SELECT * FROM drug")
    @RegisterBeanMapper(Drug.class)
    List<Drug> selectAll();

    @SqlQuery("SELECT * FROM drug WHERE id = :id")
    @RegisterBeanMapper(Drug.class)
    Drug selectById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO drug (name) value (:name)")
    int insert(@BindBean Drug drug);

    @SqlUpdate("DELETE FROM drug WHERE id = :id")
    void delete(@Bind("id") Long id);

    @SqlUpdate("UPDATE drug SET name = :name WHERE id = :drug_id")
    int update(@Bind("drug_id") Long id, @BindBean Drug drug);

    @SqlQuery("SELECT * FROM drug WHERE name = :name LIMIT 1")
    @RegisterBeanMapper(Drug.class)
    Drug findByName(@Bind("name") String name);
}
