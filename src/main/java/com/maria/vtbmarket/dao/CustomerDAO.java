package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.Customer;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends DAO<Customer, Integer>{
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO customer (username, password, customer_info, customer_id) VALUES (?, ?, ?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM customer WHERE customer_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE customer SET username = ?, password = ?, customer_info = ? WHERE customer_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM customer WHERE customer_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, Customer customer) {

        try{
            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getPassword());
            stmt.setInt(3, customer.getInfo().getId());
            stmt.setInt(4, customer.getId());
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
    protected Customer getObject(ResultSet rs) {

        Customer customer = new Customer();
        try{
            customer.setId(rs.getInt("customer_id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setInfo(new CustomerInfoDAO().read(rs.getInt("customer_info")));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return customer;

    }

    @Override
    public void delete(Integer customerId){
        Customer customer = read(customerId);
        executeQuery("DELETE FROM customer_info WHERE customer_info_id = " + customer.getInfo().getId() + ";");
        executeQuery("DELETE FROM purchase WHERE purchase.customer_id = " + customerId + ";");
        executeQuery("DELETE FROM ticket WHERE ticket.customer_id = " + customerId + ";");
        super.delete(customerId);
    }

}
