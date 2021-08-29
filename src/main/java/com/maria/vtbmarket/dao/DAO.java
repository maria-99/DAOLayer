package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.exception.DAOException;

import java.sql.*;

public abstract class DAO<O, K> {

    protected abstract String getCreateQuery();         //create query
    protected abstract String getSelectByIdQuery();     //read query
    protected abstract String getUpdateQuery();         //update query
    protected abstract String getDeleteQuery();         //delete query
    protected abstract void setFieldsInStatement(PreparedStatement stmt, O obj);
    protected abstract void setIdInStatement(PreparedStatement stmt, K id);
    protected abstract O getObject(ResultSet rs);

    public void create(O obj){
        String createQuery = getCreateQuery();

        try(Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(createQuery)){

            setFieldsInStatement(stmt, obj);
            if (stmt.executeUpdate() == 0){
                throw new DAOException("Create err: Object not added to DB");
            }

        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    };

    public O read(K id){
        O obj;
        String selectByIdQuery = getSelectByIdQuery();

        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(selectByIdQuery)){

            setIdInStatement(stmt, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                obj = getObject(rs);
            } else {
                throw new DAOException("Read err: No such object");
            }

        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }

        return obj;

    };

    public void update(O obj){
        String updateQuery = getUpdateQuery();

        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(updateQuery)){

            setFieldsInStatement(stmt, obj);
            if (stmt.executeUpdate() == 0){
                throw new DAOException("Update err: Object not updates in DB");
            }

        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    };

    public void delete(K id){

        String deleteQuery = getDeleteQuery();

        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(deleteQuery)){

            setIdInStatement(stmt, id);
            if (stmt.executeUpdate() == 0){
                throw new DAOException("Delete err: Object not deleted from DB");
            }

        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }

    };

    protected void executeQuery(String query) throws DAOException {
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

}
