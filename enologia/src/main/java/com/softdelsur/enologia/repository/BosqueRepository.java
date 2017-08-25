package com.softdelsur.enologia.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softdelsur.enologia.entity.Bosque;

@Repository("bosqueRepository")
public interface BosqueRepository extends JpaRepository<Bosque, Serializable>{

}
