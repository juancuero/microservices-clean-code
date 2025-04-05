package com.juancuero.output.jpa.repository;

import com.juancuero.output.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, UUID> {

}
