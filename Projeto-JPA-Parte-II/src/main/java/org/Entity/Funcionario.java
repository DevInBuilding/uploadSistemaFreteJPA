package org.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
public @Data class Funcionario extends PessoaFisica {

    private Integer matricula;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Set<Dependente> dependentes = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;

    public void adiciona(Dependente dependente) {
        dependentes.add(dependente);
    }
}
