package com.aula2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor

public class Estado  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @JsonIgnoreProperties("estado")
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();



    public Estado(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

}