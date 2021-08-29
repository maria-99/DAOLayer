package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.PurchaseStatus;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseStatusDAO extends DAO<PurchaseStatus,Integer> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO purchase_status (purchase_status, purchase_status_id) VALUES (?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM purchase_status WHERE purchase_status_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE purchase_status SET purchase_status = ? WHERE purchase_status_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM purchase_status WHERE purchase_status_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, PurchaseStatus status) {

        try {
            stmt.setString(1, status.getStatus());
            stmt.setInt(2, status.getId());
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Integer id) {

        try {
            stmt.setInt(1, id);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    protected PurchaseStatus getObject(ResultSet rs) {

        PurchaseStatus purchaseStatus = new PurchaseStatus();
        try {
            purchaseStatus.setId(rs.getInt("purchase_status_id"));
            purchaseStatus.setStatus(rs.getString("purchase_status"));
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return purchaseStatus;

    }
}