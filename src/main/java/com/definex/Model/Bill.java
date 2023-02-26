package com.definex.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bill", schema = "public")
public class Bill {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill_number")
    private Boolean creditStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer cutomerId;

    @Column(name = "limit")
    private Double limit;


}

    