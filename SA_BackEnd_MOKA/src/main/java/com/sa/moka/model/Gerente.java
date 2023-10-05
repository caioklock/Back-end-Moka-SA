package com.sa.moka.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salas; 
    private Long tel_gerente;
    private String nome_gerente;
    
}
