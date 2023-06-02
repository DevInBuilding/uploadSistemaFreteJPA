package org.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categoria_frete")
public @Data class CategoriaFrete implements EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    @Column(name = "percentual_adicional")
    private float percentualAdicional;

    @OneToMany(mappedBy = "frete_id", cascade = CascadeType.ALL)
    private Set<Frete> fretes = new LinkedHashSet<>();
}
