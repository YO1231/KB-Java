package AM.ch06.sec15;

public class Database {
    private static Database database = new Database();

    private String connection = "MySQL";

    private Database() {
    }

    public static Database getInstance() {
        return database;
    }

    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }
}


class DatabaseExample {
    public static void main(String[] args) {
        Database db = Database.getInstance();

        String connection = db.connect();
        System.out.println("데이터베이스: " + connection);
        db.close();
    }
}