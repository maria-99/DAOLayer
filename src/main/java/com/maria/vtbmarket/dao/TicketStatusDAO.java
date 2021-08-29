package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.TicketStatus;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketStatusDAO extends DAO<TicketStatus,Integer> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO ticket_status (ticket_status, ticket_status_id) VALUES (?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM ticket_status WHERE ticket_status_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE ticket_status SET ticket_status = ? WHERE ticket_status_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM ticket_status WHERE ticket_status_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, TicketStatus status) {

        try{
            stmt.setString(1, status.getStatus());
            stmt.setInt(2, status.getId());
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
    protected TicketStatus getObject(ResultSet rs) {

        TicketStatus ticketStatus = new TicketStatus();
        try{
            ticketStatus.setId(rs.getInt("ticket_status_id"));
            ticketStatus.setStatus(rs.getString("ticket_status"));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return ticketStatus;

    }
}