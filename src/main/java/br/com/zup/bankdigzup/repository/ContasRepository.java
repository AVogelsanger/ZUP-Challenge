package br.com.zup.bankdigzup.repository;

import br.com.zup.bankdigzup.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends CrudRepository<Conta, Long> {
}
