package org.Executable;

import org.Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        //Definindo cliente
        Cliente joao = new Cliente();
        joao.setNome("José Abreu");
        joao.setEmail("abreu.jose@gmail.com");
        joao.setTelefone("98999050608");
        joao.setCpf("154.653.253-98");
        joao.setContato("98995954643");
        joao.setStatus(1);

        //Definindo funcionario e dependente
        Funcionario luis = new Funcionario();
        luis.setNome("Luís Bezerra");
        luis.setEmail("bezerra.luis@hotmail.com");
        luis.setTelefone("98999050608");
        luis.setCpf("154.653.253-98");
        luis.setMatricula(20230115);

        Dependente maria = new Dependente();
        maria.setName("Maria Coelho");
        maria.setDataNascimento(Date.valueOf("1996-10-25"));

        luis.adiciona(maria); //Add dependente à lista

        //Definindo veiculo
        Veiculo boxer = new Veiculo();
        boxer.setNumeroPlaca("FFA5A05");

        //Definindo tipo do veiculo
        TipoVeiculo cargueiro = new TipoVeiculo();
        cargueiro.setDescricao("Veículo de transporte de mercadorias");
        cargueiro.setPesoMaximo(3250.00F);

        //Definindo item do frete
        ItemFrete abajur = new ItemFrete();
        abajur.setDescricao("Abajur de duplo bocal - Preto");
        abajur.setPeso(155.63F);

        //Definindo a cidade
        Cidade cidade = new Cidade();
        cidade.setUf("SP");
        cidade.setEstado("São Paulo");
        cidade.setName("São Carlos");

        //Definindo categoria do frete
        CategoriaFrete freteSimples = new CategoriaFrete();
        freteSimples.setNome("Frete simples");
        freteSimples.setDescricao("Não se aplica");
        freteSimples.setPercentualAdicional(10.59F);

        //Definindo filial
        Filial regNorte = new Filial();
        regNorte.setNome("Filial 01- Região Norte");
        regNorte.setEndereco("Avenida São Sebastião, nº43, Vila Velha, ES, 11253-000");
        regNorte.setTelefone("(15)3542-1231");

        //Definindo o frete
        Frete frete = new Frete();
        frete.setCodigo(05310012);
        frete.setNumeroNotaFiscal(230531210);
        frete.setValorKmRodado(new BigDecimal(2.95));

        frete.adicionaItens(abajur);

        manager.persist(frete);

        transaction.commit();

        manager.close();
        factory.close();

    }
}
