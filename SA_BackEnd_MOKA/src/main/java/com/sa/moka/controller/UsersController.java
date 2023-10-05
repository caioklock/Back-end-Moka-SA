package com.sa.moka.controller;
import com.sa.moka.model.Users;
import com.sa.moka.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> listarUsers() {
        return usersRepository.findAll();
    }

    @PostMapping
    public Users criarUsers(@RequestBody Users users) {
        return usersRepository.save(users);
    }

    @DeleteMapping("/{Cpf_users}")
    public ResponseEntity<String> deletarUsers(@PathVariable Long Cpf_users) {
        try {
            usersRepository.deleteById(Cpf_users); // Corrigido para usersRepository
            return ResponseEntity.ok("Usuario deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{Cpf_users}")
public ResponseEntity<Users> atualizarUsers(@PathVariable Long Cpf_users, @RequestBody Users usersAtualizado) {
    if (usersRepository.existsById(Cpf_users)) {
        Users user = usersRepository.findById(Cpf_users).get();
        user.setCpf_users(usersAtualizado.getCpf_users()); // Corrigido para setId_users
        user.setName_users(usersAtualizado.getName_users()); // Corrigido para setName_users
        user.setTel_users(usersAtualizado.getTel_users()); // Corrigido para setEmail_users

        Users usersAtualizadoBD = usersRepository.save(user);
        return ResponseEntity.ok(usersAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
