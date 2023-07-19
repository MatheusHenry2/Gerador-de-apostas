package com.example.demo.controllers;

import com.example.demo.dtos.ApostasDto;
import com.example.demo.models.ApostasModel;
import com.example.demo.services.ApostasService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/apostas")
public class ApostasController {

    final ApostasService apostasService;

    public ApostasController(ApostasService apostasService) {
        this.apostasService = apostasService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Map<String, Object>> generateBet(@RequestParam Integer amount) {

        List<Integer> numerosAposta = apostasService.generateBet(amount);
        Map<String, Object> response = new HashMap<>();

        response.put("message", "Aposta criada com sucesso");
        response.put("bets", numerosAposta);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Message", "Bets:");

        ApostasModel apostasModel = new ApostasModel();

        apostasModel.setBetNumbers(numerosAposta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(response);
    }
}
