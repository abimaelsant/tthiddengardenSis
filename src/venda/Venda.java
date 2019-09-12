package venda;

import java.util.Date;

public class Venda {
    private int id;
    private int produtoId;
    private int quantidade;
    private int clienteId;
    private double valorV;
    private Date dataV;
    private boolean statusV;
    
    public Venda() {}
    
    public Venda(int produtoId, int quantidade, int clienteId, double valor, boolean statusV) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.clienteId = clienteId;
        this.valorV = valor;
        this.statusV = statusV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getValorV() {
        return valorV;
    }

    public void setValorV(double valorV) {
        this.valorV = valorV;
    }

    public Date getDataV() {
        return dataV;
    }

    public void setDataV(Date dataV) {
        this.dataV = dataV;
    }

    public boolean isStatusV() {
        return statusV;
    }

    public void setStatusV(boolean statusV) {
        this.statusV = statusV;
    }
}
