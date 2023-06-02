package org.Repository;

import org.Entity.Cliente;
import org.Entity.Frete;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class FreteRepository {

    private final EntityManager manager;
    private final DAOGenerico<Frete> daoGenerico;

    public FreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Frete buscaPor(Integer codigo) {
        return daoGenerico.buscaPorId(Frete.class, codigo);
    }

    public Frete salvaOuAtualiza(Frete frete) {
        return daoGenerico.salvaOuAtualiza(frete);
    }
}
