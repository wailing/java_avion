package persistance;

        import java.sql.Connection;
        import java.sql.DriverManager;



public class ConnexionBD {
    private static String driver ;
    private static String url, login, password ;
    private static Connection connexion ;

    static {
        try {
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            url = "jdbc:mysql://localhost/java_avion";
            login = "anais";
            password = "anais";
            connexion = DriverManager.getConnection(url,login,password);

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    public static Connection getConnexionBD() {
        return connexion;
    }

}
