package com.alby.gymservices.repository;

import com.alby.gymservices.entity.program.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {

    Program findByProgramCategory(Long findByProgramCategory);
}
