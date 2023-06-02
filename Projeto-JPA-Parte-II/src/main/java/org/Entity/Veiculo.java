package org.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "veiculo")
public @Data class Veiculo implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_placa")
    private String numeroPlaca;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private Set<Frete> fretes = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "tipveiculo_id", nullable = false)
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;


}
