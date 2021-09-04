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
public class TicketPriority {

    @Id
    @Column(name = "ticket_priority_id")
    private int id;

    @Column(name = "ticket_priority")
    private String priority;

    @OneToMany(mappedBy = "ticketPriority", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Ticket> tickets = new LinkedList<>();

    public TicketPriority(int id, String priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "TicketPriority{" + priority + '}';
    }
}
