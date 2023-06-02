package org.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "distancia")
public @Data class Distancia {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private DistanciaPK id = new DistanciaPK();

    private Integer quilometros;

    @Column(name = "adicional_km_rodado")
    private float adicionalKmRodado;

    public void setOrigem(Cidade origem) {
        id.setOrigem(origem);
    }

    public void setDestino(Cidade destino) {
        id.setDestino(destino);
    }

    public Cidade getOrigem() {
        return id.getOrigem();
    }

    public Cidade getDestino() {
        return id.getDestino();
    }
}
