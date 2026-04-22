package PM.Interfaces.solid;

public class MySQLRepository implements UserRepository {
    @Override
    public void save(String data) {
        System.out.println("MySQL 저장: " + data);
    }
}
