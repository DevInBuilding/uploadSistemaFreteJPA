package org.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tipo_veiculo")
public @Data class TipoVeiculo implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @Column(name = "peso_maximo")
    private float pesoMaximo;

}
