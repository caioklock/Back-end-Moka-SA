package com.sa.moka.controller;
import com.sa.moka.model.Produto;
import com.sa.moka.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository ProdutoRepository;
    @GetMapping
    public List<Produto> listarProduto() {
        return ProdutoRepository.findAll();
    }
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return ProdutoRepository.save(produto);
    }

}
