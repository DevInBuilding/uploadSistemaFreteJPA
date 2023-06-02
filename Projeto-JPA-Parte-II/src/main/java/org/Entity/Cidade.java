package org.Entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cidade")
public @Data class Cidade implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uf;

    private String name;

    private String estado;

    @Getter
    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private Set<Frete> fretesOrigem = new LinkedHashSet<>();

    @Getter
    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private Set<Frete> fretesDestino = new LinkedHashSet<>();

    public void adicionaOrigem(Frete origem) {
        fretesOrigem.add(origem);
    }

    public void adicionaDestino(Frete destino) {
        fretesDestino.add(destino);
    }
}
