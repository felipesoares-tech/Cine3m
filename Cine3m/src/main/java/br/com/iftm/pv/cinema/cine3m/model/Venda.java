package br.com.iftm.pv.cinema.cine3m.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Venda {

    private Sessao sessao;
    private Cliente cliente;
    private Funcionario funcionario;
    private final String identificador;
    private Double valorFinal;
    private List<ItemVenda> itensVenda;
    private boolean cancelada;
    private boolean desconto;

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensIngresso(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    /**
     *
     * @return retorna uma lista de poltronas que foram selecionadas na venda
     */
    public List<Poltrona> consultaPoltronasVenda() {
        Iterator<ItemVenda> it = getItensVenda().iterator();

        List<Poltrona> listPoltronas = new ArrayList<>();

        while (it.hasNext()) {
            ItemVenda item = (ItemVenda) it.next();
            listPoltronas.add(item.getPoltrona());
        }
        return listPoltronas;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Venda(Funcionario funcionario, Sessao sessao, Double valorFinal, List<ItemVenda> itensVenda) {
        this.sessao = sessao;
        this.valorFinal = valorFinal;
        this.itensVenda = itensVenda;
        this.funcionario = funcionario;
        this.identificador = "VENDA" + " - " + funcionario.getNome() + " - " + sessao.toString();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Venda(Funcionario funcionario, Sessao sessao, Cliente cliente, Double valorFinal, List<ItemVenda> itensVenda) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.valorFinal = valorFinal;
        this.itensVenda = itensVenda;
        this.funcionario = funcionario;
        this.identificador = "VENDA" + " - " + funcionario.getNome() + " - " + sessao.toString();
    }

    public boolean hasDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return getIdentificador();
    }

}
