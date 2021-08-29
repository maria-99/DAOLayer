package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.Product;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends DAO<Product, Integer>{
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO product " +
                "(product_name, product_description, product_code, product_price, product_category, product_id) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM product WHERE product_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE product SET " +
                "product_name = ?, product_description = ?, product_code = ?, product_price = ?, product_category = ? " +
                "WHERE product_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM product WHERE product_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, Product product) {

        try{
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getCode());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getCategory().getId());
            stmt.setInt(6, product.getId());
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
    protected Product getObject(ResultSet rs) {

        Product product = new Product();
        try{
            product.setId(rs.getInt("product_id"));
            product.setName(rs.getString("product_name"));
            product.setDescription(rs.getString("product_description"));
            product.setCode(rs.getString("product_code"));
            product.setPrice(rs.getDouble("product_price"));
            product.setCategory(new ProductCategoryDAO().read(rs.getInt("product_category")));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return product;

    }

}
