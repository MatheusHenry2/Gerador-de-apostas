package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

public class ApostasDto {
    List<Integer> betNumbers = new ArrayList<>();

    public List<Integer> getBetNumbers() {
        return betNumbers;
    }

    public void setBetNumbers(List<Integer> betNumbers) {
        this.betNumbers = betNumbers;
    }
}
