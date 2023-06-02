package org.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "frete")
public @Data class Frete implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigo;

    @Column(name = "numero_nota_fiscal")
    private Integer numeroNotaFiscal;

    @Column(name = "valor_km_rodado")
    private BigDecimal valorKmRodado;

    @OneToMany(mappedBy = "frete", cascade = CascadeType.ALL)
    private Set<ItemFrete> itensFrete = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "catfrete_id", nullable = false)
    private CategoriaFrete categoriaFrete;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidadeDestino;

    public void adicionaItens(ItemFrete item) {
        itensFrete.add(item);
    }

}
