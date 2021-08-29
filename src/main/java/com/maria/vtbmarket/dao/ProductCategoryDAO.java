package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.ProductCategory;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryDAO extends DAO<ProductCategory ,Integer> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO product_category (product_category, product_category_id) VALUES (?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM product_category WHERE product_category_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE product_category SET product_category = ? WHERE product_category_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM product_category WHERE product_category_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, ProductCategory category) {

        try{
            stmt.setString(1, category.getCategory());
            stmt.setInt(2, category.getId());
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
    protected ProductCategory getObject(ResultSet rs) {

        ProductCategory productCategory = new ProductCategory();
        try{
            productCategory.setId(rs.getInt("product_category_id"));
            productCategory.setCategory(rs.getString("product_category"));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return productCategory;

    }
}