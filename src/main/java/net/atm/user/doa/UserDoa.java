package net.atm.user.doa;

import net.atm.user.model.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;


public interface UserDoa{

    @SqlUpdate("insert into users (id, first_name, last_name, password, cell_num, date_created) " +
            "values(:id, :firstName, :lastName, :password, :cellNo, :dateCreated")
    void insertUser(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName,
                    @Bind("password") String password, @Bind("cellNo") int cellNo, @Bind("dateCreated") LocalDate dateCreated);

    @SqlUpdate("update users set first_name=:firstName, last_name=:lastName, password=:password, cell_num=:cellNo where id=:id" )
    void updateUser(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName,
                    @Bind("password") String password, @Bind("cellNo") int cellNo);

    @SqlQuery("select * from users where id=:id")
    User selectUser(@Bind("id") int id);

    @SqlQuery("select * from users")
    List<User> selectAllUser();

}