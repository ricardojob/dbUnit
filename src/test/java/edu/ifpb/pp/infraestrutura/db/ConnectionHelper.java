package edu.ifpb.pp.infraestrutura.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class ConnectionHelper {

    private ConnectionHelper() {
    }

    public static Connection getConnection() throws InfrastructureException {
        try {
            ResourceBundle banco = ResourceBundle.getBundle("bancoTeste");

            Class.forName(banco.getString("drive"));
            return DriverManager.getConnection(banco.getString("url"),
                    banco.getString("usuario"),
                    banco.getString("senha"));
        } catch (ClassNotFoundException e) {
            throw new InfrastructureException(e.getMessage(), e);
        } catch (SQLException e) {
            throw new InfrastructureException(e.getMessage(), e);
        }
    }

}
