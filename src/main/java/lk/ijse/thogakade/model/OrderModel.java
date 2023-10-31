package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 10/31/23 - 12:04 PM   
*/

import lk.ijse.thogakade.db.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {
    public String generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String currentOrderId = null;

        if(resultSet.next()) {
            currentOrderId = resultSet.getString(1);
            return splitOrderId(currentOrderId);
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentOrderId) {    //O008
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("O");
            int id = Integer.parseInt(split[1]);    //008
            id ++;  //9
            return "O00" + id;
        }
        return "O001";
    }
}
