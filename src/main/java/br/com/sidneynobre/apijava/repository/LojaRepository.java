package br.com.sidneynobre.apijava.repository;

import br.com.sidneynobre.apijava.entity.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{
}
