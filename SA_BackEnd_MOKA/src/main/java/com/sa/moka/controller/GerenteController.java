package com.sa.moka.controller;
import com.sa.moka.model.Gerente;
import com.sa.moka.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/gerente")
public class GerenteController {
 @Autowired
    private GerenteRepository GerenteRepository;
 @GetMapping
    public List<Gerente> listargerente() {
        return GerenteRepository.findAll();
    }
   @PostMapping
    public Gerente criarGerente(@RequestBody Gerente gerente) {
        return GerenteRepository.save(gerente);
    }

}