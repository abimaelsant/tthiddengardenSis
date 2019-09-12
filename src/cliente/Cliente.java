package cliente;

import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String sexo;
    
    public Cliente() {}
    
    public Cliente(String nome, String cpf, String rg, Date dataNascimento, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public boolean verificaIdade(Date data) {
        Date dataAtual = new Date();
        int anoAtual = dataAtual.getYear() + 1900;
        int anos = anoAtual - (data.getYear() + 1900);
        int mesAtual = dataAtual.getMonth();
        int mes = data.getMonth();
        int diaAtual = dataAtual.getDate();
        int dia = data.getDate();
        if(anos == 18 && mesAtual >= mes && diaAtual >= dia) return true;
        else return anos > 18;
    }
    
    public String retiraMascaraCpf(String cpf) {
        String c = cpf.replaceAll("\\.", "");
        String c2 = c.replaceAll("-", "");
        return c2;
    }
}
