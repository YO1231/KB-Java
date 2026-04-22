package PM.Interfaces.solid;

public class OracleRepository implements UserRepository {
    @Override
    public void save(String data) {
        System.out.println("Oracle 저장: " + data);
    }
}
