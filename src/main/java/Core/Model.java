package Core;

import Core.Database.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Model {

    protected Connection connexion = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;

    public Model() {
        this.setConnexion(Connect.initConnect());
    }

    public Model(Connection connexion, Statement statement, ResultSet resultSet) {
        this.connexion = connexion;
        this.statement = statement;
        this.resultSet = resultSet;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
