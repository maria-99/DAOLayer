package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.ProductCategory;
import com.maria.vtbmarket.entity.ProductsInPurchase;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsInPurchaseDAO extends DAO<ProductsInPurchase, Integer[]> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO products_in_purchase (product_quantity, purchase, product) VALUES (?, ?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM products_in_purchase WHERE purchase = ? AND product = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE products_in_purchase SET product_quantity = ? " +
                "WHERE purchase = ?, product = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM products_in_purchase WHERE purchase = ?, product = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, ProductsInPurchase productsInPurchase) {

        try{
            stmt.setInt(1, productsInPurchase.getProductQuantity());
            stmt.setInt(2, productsInPurchase.getPurchase().getId());
            stmt.setInt(3, productsInPurchase.getProduct().getId());
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Integer[] id) {

        try{
            stmt.setInt(1, id[0]);
            stmt.setInt(2, id[1]);
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    protected ProductsInPurchase getObject(ResultSet rs) {

        ProductsInPurchase productsInPurchase = new ProductsInPurchase();
        try{
            productsInPurchase.setPurchase(new PurchaseDAO().read(rs.getInt("purchase")));
            productsInPurchase.setProduct(new ProductDAO().read(rs.getInt("product")));
            productsInPurchase.setProductQuantity(rs.getInt("product_quantity"));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return productsInPurchase;

    }
}