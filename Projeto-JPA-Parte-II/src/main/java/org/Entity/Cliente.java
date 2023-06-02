package org.Entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public @Data class Cliente extends PessoaFisica implements EntidadeBase {

    private String contato;

    private Integer status; //0- Inativo ; 1- Ativo

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Frete> fretes = new LinkedHashSet<>();
}
