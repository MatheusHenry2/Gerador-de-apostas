package com.example.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_APOSTAS")
public class ApostasModel implements Serializable {

    private static final long serialVersonUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Integer> getBetNumbers() {
        return betNumbers;
    }

    public void setBetNumbers(List<Integer> betNumbers) {
        this.betNumbers = betNumbers;
    }

    @ElementCollection
    @Column
    List<Integer> betNumbers = new ArrayList<>();

}