package com.maria.vtbmarket.dao;

import com.maria.vtbmarket.entity.Customer;
import com.maria.vtbmarket.entity.Ticket;
import com.maria.vtbmarket.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO extends DAO<Ticket, Integer> {

    @Override
    protected String getCreateQuery() {
        return "INSERT INTO ticket " +
                "(customer, ticket_text, ticket_priority, ticket_status, ticket_date, ticket_id) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM ticket WHERE ticket_id = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE ticket SET " +
                "customer = ?, ticket_text = ?, ticket_priority = ?, ticket_status = ?, ticket_date = ? " +
                "WHERE ticket_id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM ticket WHERE ticket_id = ?;";
    }

    @Override
    protected void setFieldsInStatement(PreparedStatement stmt, Ticket ticket) {

        try{
            stmt.setInt(1, ticket.getCustomer().getId());
            stmt.setString(2, ticket.getText());
            stmt.setInt(3, ticket.getPriority().getId());
            stmt.setInt(4, ticket.getStatus().getId());
            stmt.setDate(5, ticket.getDate());
            stmt.setInt(1, ticket.getId());
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
    protected Ticket getObject(ResultSet rs) {
        Ticket ticket = new Ticket();
        try{
            ticket.setId(rs.getInt("ticket_id"));
            ticket.setCustomer(new CustomerDAO().read(rs.getInt("customer")));
            ticket.setText(rs.getString("ticket_text"));
            ticket.setPriority(new TicketPriorityDAO().read(rs.getInt("ticket_priority")));
            ticket.setStatus(new TicketStatusDAO().read(rs.getInt("ticket_status")));
            ticket.setDate(rs.getDate("ticket_date"));
        } catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        return ticket;
    }
}
