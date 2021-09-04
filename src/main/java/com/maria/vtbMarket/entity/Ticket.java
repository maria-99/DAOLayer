package com.maria.vtbMarket.entity;

import java.sql.Date;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    private int id;

    @Column(name = "ticket_text")
    private String text;

    @Column(name = "ticket_date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_priority")
    private TicketPriority ticketPriority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_status")
    private TicketStatus ticketStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer")
    private Customer ticketCustomer;

}
