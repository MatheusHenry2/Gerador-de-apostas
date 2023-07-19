package com.example.demo.repositories;

import com.example.demo.models.ApostasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApostasRepository extends JpaRepository<ApostasModel, UUID> {

}

