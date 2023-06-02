package org.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "filial")
public @Data class Filial implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String endereco;

    private String telefone;

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    private Set<Veiculo> veiculos = new LinkedHashSet<>();


}
