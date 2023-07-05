package com.frc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frc.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {

}
