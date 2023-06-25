package br.com.iftm.pv.cinema.cine3m.model;

public class Venda {
    private Integer id;
    private Sessao sessao;
    private Cliente cliente;
    private Funcionario funcionario;
    private final String identificador;
    private Double valorFinal;
    private boolean cancelada;
    private boolean desconto;
    private boolean del;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Venda(Funcionario funcionario, Sessao sessao, Double valorFinal) {
        this.sessao = sessao;
        this.valorFinal = valorFinal;
        this.funcionario = funcionario;
        this.identificador = "VENDA" + " - " + funcionario.getNome() + " - " + sessao.toString();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Venda(Funcionario funcionario, Sessao sessao, Cliente cliente, Double valorFinal) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.valorFinal = valorFinal;
        this.funcionario = funcionario;
        this.identificador = "VENDA" + " - " + funcionario.getNome() + " - " + sessao.toString();
    }
    
    public Venda(Integer id,Funcionario funcionario, Sessao sessao, Cliente cliente, Double valorFinal, String identificador, boolean cancelada, boolean desconto, boolean del) {
        this.id = id;
        this.sessao = sessao;
        this.cliente = cliente;
        this.valorFinal = valorFinal;
        this.funcionario = funcionario;
        this.identificador = identificador;
        this.cancelada = cancelada;
        this.desconto = desconto;
        this.del = del;
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

    public boolean isDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return getIdentificador();
    }

}
