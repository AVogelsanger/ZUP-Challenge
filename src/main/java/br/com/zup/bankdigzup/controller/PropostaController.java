package br.com.zup.bankdigzup.controller;

import br.com.zup.bankdigzup.error.CustomErrorType;
import br.com.zup.bankdigzup.model.Proposta;
import br.com.zup.bankdigzup.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("propostas")
public class PropostaController {

    private final PropostaRepository propostaDao;
    @Autowired
    public PropostaController(PropostaRepository propostaDao) {
        this.propostaDao = propostaDao;
    }

    @GetMapping
    public ResponseEntity<?> listAllProposta(){
        return new ResponseEntity<>(propostaDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{/{id}")
    public ResponseEntity<?> getPropostaById(@PathVariable("id") Long id){
        Optional<Proposta> proposta = propostaDao.findById(id);
        if (proposta == null)
            return new ResponseEntity<>(new CustomErrorType("Proposta NOT_FOUND"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(proposta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProposta(@RequestBody Proposta proposta){
        return new ResponseEntity<>(propostaDao.save(proposta), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProposta(@PathVariable Long id){
        propostaDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProposta(@RequestBody Proposta proposta){
        propostaDao.save(proposta);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
