package produto;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double custoLote;
    private double freteTotal;
    private double freteUnitario;
    private double custoUnitario;
    private double custoUnitarioComFrete;
    private double precoUnitario;
    private double lucroUnitario;
    private double lucroLote;
    
    public Produto() {}
    
    public Produto(String nome, int quantidade, double custoLote, double freteTotal, double freteUnitario, double custoUnitario, double custoUnitarioComFrete, double precoUnitario, double lucroUnitario, double lucroLote){
        this.nome = nome;
        this.quantidade = quantidade;
        this.custoLote = custoLote;
        this.freteTotal = freteTotal;
        this.freteUnitario = freteUnitario;
        this.custoUnitario = custoUnitario;
        this.custoUnitarioComFrete = custoUnitarioComFrete;
        this.precoUnitario = precoUnitario;
        this.lucroUnitario = lucroUnitario;
        this.lucroLote = lucroLote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getCustoLote() {
        return custoLote;
    }

    public void setCustoLote(double custoLote) {
        this.custoLote = custoLote;
    }

    public double getFreteTotal() {
        return freteTotal;
    }

    public void setFreteTotal(double freteTotal) {
        this.freteTotal = freteTotal;
    }

    public double getFreteUnitario() {
        return freteUnitario;
    }

    public void setFreteUnitario(double freteUnitario) {
        this.freteUnitario = freteUnitario;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public double getCustoUnitarioComFrete() {
        return custoUnitarioComFrete;
    }

    public void setCustoUnitarioComFrete(double custoUnitarioComFrete) {
        this.custoUnitarioComFrete = custoUnitarioComFrete;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getLucroUnitario() {
        return lucroUnitario;
    }

    public void setLucroUnitario(double lucroUnitario) {
        this.lucroUnitario = lucroUnitario;
    }

    public double getLucroLote() {
        return lucroLote;
    }

    public void setLucroLote(double lucroLote) {
        this.lucroLote = lucroLote;
    }
}
