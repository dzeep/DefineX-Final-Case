package com.definex.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "credit", schema = "public")
public class Credit {

    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    private Long id;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "credit_limit")
    private Double limit;

    @Column(name = "credit_result")
    private String creditResult;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_id", nullable = false)
//    @JsonIgnore
//    private Customer customer;




}

    