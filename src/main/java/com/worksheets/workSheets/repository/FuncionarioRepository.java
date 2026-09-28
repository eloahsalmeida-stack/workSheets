package com.worksheets.workSheets.repository;

import com.worksheets.workSheets.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
