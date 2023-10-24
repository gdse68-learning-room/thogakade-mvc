package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 10/24/23 - 10:38 AM   
*/

import lk.ijse.thogakade.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerModel {
    public boolean saveCustomer(String id, String name, String address, String tel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);
        pstm.setString(2, name);
        pstm.setString(3, address);
        pstm.setString(4, tel);

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public boolean updateCustomer(String id, String name, String address, String tel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET name = ?, address = ?, tel = ? WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, name);
        pstm.setString(2, address);
        pstm.setString(3, tel);
        pstm.setString(4, id);

        return pstm.executeUpdate() > 0;
    }
}
