package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.TicketPriority;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketPriorityDAO extends DAO<TicketPriority,Integer> {
    @Override
    protected String getCreateQuery() {
        return "INSERT INTO ticket_priority (ticket_priority, ticket_priority_id) VALUES (?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM ticket_priority WHERE ticket_priority_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE ticket_priority SET ticket_priority = ? WHERE ticket_priority_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM ticket_priority WHERE ticket_priority_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, TicketPriority priority) {

        try{
            stmt.setString(1, priority.getPriority());
            stmt.setInt(2, priority.getId());
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
    protected TicketPriority getObject(ResultSet rs) {

        TicketPriority ticketPriority = new TicketPriority();
        try{
            ticketPriority.setId(rs.getInt("ticket_priority_id"));
            ticketPriority.setPriority(rs.getString("ticket_priority"));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return ticketPriority;

    }
}
