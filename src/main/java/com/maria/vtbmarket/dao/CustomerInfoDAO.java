package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.Customer;
import com.maria.vtbmarket.entity.CustomerInfo;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfoDAO extends DAO<CustomerInfo, Integer>{
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO customer_info " +
                "(customer_name, customer_surname, customer_tel, customer_address, customer_info_id) " +
                "VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM customer_info WHERE customer_info_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE customer_info SET " +
                "customer_name = ?, customer_surname = ?, customer_tel = ?, customer_address = ? " +
                "WHERE customer_info_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM customer_info WHERE customer_info_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, CustomerInfo customerInfo) {

        try{
            stmt.setString(1, customerInfo.getName());
            stmt.setString(2, customerInfo.getSurname());
            stmt.setString(3, customerInfo.getTelephone());
            stmt.setString(4, customerInfo.getAddress());
            stmt.setInt(5, customerInfo.getId());
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
    protected CustomerInfo getObject(ResultSet rs) {

        CustomerInfo customerInfo = new CustomerInfo();
        try{
            customerInfo.setId(rs.getInt("customer_info_id"));
            customerInfo.setName(rs.getString("customer_name"));
            customerInfo.setSurname(rs.getString("customer_surname"));
            customerInfo.setTelephone(rs.getString("customer_tel"));
            customerInfo.setAddress(rs.getString("customer_address"));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return customerInfo;

    }

}
