package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketStatus {

    @Id
    @Column(name = "ticket_status_id")
    private int id;

    @Column(name = "ticket_status")
    private String status;

    @OneToMany(mappedBy = "ticketStatus", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Ticket> tickets = new LinkedList<>();

    public TicketStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicketStatus{" + status + '}';
    }
}
