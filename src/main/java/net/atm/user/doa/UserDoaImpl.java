package net.atm.user.doa;

import net.atm.user.mapper.UserMapper;
import net.atm.user.model.User;
import org.jdbi.v3.core.Jdbi;
//import org.jdbi.v3.core.spi.JdbiPlugin.Singleton;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.jdbi.v3.sqlobject.customizer.Bind;

import java.time.LocalDate;
import java.util.List;

class UserDoaImpl implements UserDoa{

    private  final Jdbi  jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/bank", "thaabit", "1234");

    public UserDoaImpl(){
        jdbi.installPlugin((JdbiPlugin) new SqlObjectPlugin());
    }

    @Override
    public void insertUser(int id, String firstName,String lastName, String password, int cellNo, LocalDate dateCreated) {
        jdbi.useExtension(UserDoa.class, doa -> doa.insertUser(id, firstName, lastName, password, cellNo, dateCreated));
    }

    @Override
    public void updateUser(int id, String firstName,String lastName, String password, int cellNo) {
        jdbi.useExtension(UserDoa.class, doa -> doa.updateUser(id, firstName, lastName, password, cellNo));
    }

    @Override
    public User selectUser(int id) {
        jdbi.registerRowMapper(User.class, (rs, ctx) -> new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getInt("cell_num")));
        return jdbi.withExtension(UserDoa.class, doa -> doa.selectUser(id));
    }

    @Override
    public List<User> selectAllUser() {
        return jdbi.withExtension(UserDoa.class, doa -> doa.selectAllUser());
    }

    public static void main(String[] args) {
      //  User u = new User(1, "Mohammed Thaabit", "Jacobs", "0000", 222222222);
        User u = new User(2, "John", "Smith", "0000", 555555555);
        UserDoaImpl udi = new UserDoaImpl();
        //udi.updateUser(u.getId(), u.getFirstName(), u.getLastName(), u.getPassword(), u.getCellNo());
        udi.insertUser(u.getId(), u.getFirstName(), u.getLastName(), u.getPassword(), u.getCellNo(), u.getDateCreated());
     //   System.out.println(udi.selectUser(1));
    }

}