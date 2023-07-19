package com.example.demo.services;

import com.example.demo.models.ApostasModel;
import com.example.demo.repositories.ApostasRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ApostasService {

    final
    ApostasRepository apostasRepository;

    public ApostasService(ApostasRepository apostasRepository) {
        this.apostasRepository = apostasRepository;
    }

    public List<ApostasModel> findAll() {
        return apostasRepository.findAll();
    }

    @Transactional
    public ApostasModel save(ApostasModel apostasModel) {
        return apostasRepository.save(apostasModel);
    }

    public List<Integer> generateBet(int amount) {
        List<Integer> numbersBet = new ArrayList<>();

        Random random = new Random();
        while (numbersBet.size() < amount) {
            int number = random.nextInt(60) + 1;
            if (!numbersBet.contains(number)) {
                numbersBet.add(number);
            }
        }
        return numbersBet;
    }
}