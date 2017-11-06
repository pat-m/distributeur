package Core.Database;

import Core.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection connect = null;
    private String url = "jdbc:mysql://localhost:3306/banque_bdd?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";


    public Connect(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connect() {

        this.checkConnect();
    }

    public void checkConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(url, user, password);
            System.out.println("connexion active");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection initConnect() {

        if (connect == null) {
            new Connect();
        }
        return connect;
    }

}