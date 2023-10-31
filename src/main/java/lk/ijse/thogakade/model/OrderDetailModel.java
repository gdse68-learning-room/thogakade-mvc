package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 10/31/23 - 4:34 PM   
*/

import lk.ijse.thogakade.db.DbConnection;
import lk.ijse.thogakade.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailModel {
    public boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!saveOrderDetail(orderId, cartTm)) {
                return false;
            }
        }
        return true;
    }

    private boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, orderId);
        pstm.setString(2, cartTm.getCode());
        pstm.setInt(3, cartTm.getQty());
        pstm.setDouble(4, cartTm.getUnitPrice());

        return pstm.executeUpdate() > 0;
    }
}
