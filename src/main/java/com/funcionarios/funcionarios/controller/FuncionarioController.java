package com.funcionarios.funcionarios.controller;

import com.funcionarios.funcionarios.model.Funcionario;
import com.funcionarios.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionarios(){
        return funcionarioRepository.findAll();
    }

    @PostMapping("/funcionarios")
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id){
       Funcionario funcionarioId = funcionarioRepository.findById(id).orElseThrow(()-> new ResolutionException("Funcionario não existe com o id : "+id));
       return ResponseEntity.ok(funcionarioId);
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioUpdate){
        Funcionario funcionarioObject = funcionarioRepository.findById(id).orElseThrow(()-> new ResolutionException("Funcionario não existe com o id : "+id));

        funcionarioObject.setPrimeiro_nome(funcionarioUpdate.getPrimeiro_nome());
        funcionarioObject.setUltimo_nome(funcionarioUpdate.getUltimo_nome());
        funcionarioObject.setEmailId(funcionarioUpdate.getEmailId());

        Funcionario funcionarioObjectUpdate = funcionarioRepository.save(funcionarioObject);
        return ResponseEntity.ok(funcionarioObjectUpdate);
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Funcionario funcionarioDelete = funcionarioRepository.findById(id).
                orElseThrow(()-> new ResolutionException("Não existe funcionario com esse id "+id));

        funcionarioRepository.delete(funcionarioDelete);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
