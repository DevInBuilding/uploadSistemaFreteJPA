package org.Entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public @Data class DistanciaPK implements Serializable {
    @ManyToOne
    private Cidade origem;

    @ManyToOne
    private Cidade destino;

}
