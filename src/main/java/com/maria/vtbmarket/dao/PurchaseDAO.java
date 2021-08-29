package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.Customer;
import com.maria.vtbmarket.entity.Purchase;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDAO extends DAO<Purchase, Integer> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO purchase " +
                "(customer_id, purchase_date, delivery_info, payment_sum, purchase_status, purchase_id) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM purchase WHERE purchase_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE purchase SET " +
                "customer_id = ?, purchase_date = ?, delivery_info = ?, payment_sum = ?, purchase_status = ? " +
                "WHERE purchase_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM purchase WHERE purchase_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, Purchase purchase) {

        try{
            stmt.setInt(1, purchase.getCustomer().getId());
            stmt.setDate(2, purchase.getDate());
            stmt.setString(3, purchase.getDeliveryInfo());
            stmt.setDouble(4, purchase.getPaymentSum());
            stmt.setInt(5, purchase.getStatus().getId());
            stmt.setInt(6, purchase.getId());
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Integer id) {

        try{
            stmt.setInt(1, id);
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    protected Purchase getObject(ResultSet rs) {

        Purchase purchase = new Purchase();
        try{
            purchase.setId(rs.getInt("purchase_id"));
            purchase.setCustomer(new CustomerDAO().read(rs.getInt("customer_id")));
            purchase.setDate(rs.getDate("purchase_date"));
            purchase.setDeliveryInfo(rs.getString("delivery_info"));
            purchase.setPaymentSum(rs.getDouble("payment_sum"));
            purchase.setStatus(new PurchaseStatusDAO().read(rs.getInt("purchase_status")));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return purchase;

    }
}
