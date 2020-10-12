package br.com.zup.bankdigzup.repository;

import br.com.zup.bankdigzup.model.Proposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta, Long> {
    List<Proposta> findByNome(String nome);
}
