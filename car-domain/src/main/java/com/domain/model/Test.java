package com.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;
    @Column(name="name")
    String name;
}
