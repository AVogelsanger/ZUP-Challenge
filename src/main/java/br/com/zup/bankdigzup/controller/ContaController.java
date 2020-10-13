package br.com.zup.bankdigzup.controller;

import br.com.zup.bankdigzup.error.CustomErrorType;
import br.com.zup.bankdigzup.model.Conta;
import br.com.zup.bankdigzup.model.Proposta;
import br.com.zup.bankdigzup.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("contas")
public class ContaController {

    private final ContasRepository contaDao;

    @Autowired
    public ContaController(ContasRepository contaDao) {
        this.contaDao = contaDao;
    }

    @GetMapping
    public ResponseEntity<?> listAllConta(){
        return new ResponseEntity<>(contaDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{/{id}")
    public ResponseEntity<?> getContaById(@PathVariable("id") Long id){
        Optional<Conta> conta = contaDao.findById(id);
        if (conta == null)
            return new ResponseEntity<>(new CustomErrorType("Conta NOT_FOUND"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveConta(@RequestBody Conta conta){
        return new ResponseEntity<>(contaDao.save(conta), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteConta(@PathVariable Long id){
        contaDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateConta(@RequestBody Conta conta){
        contaDao.save(conta);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
