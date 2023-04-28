public class Funcionario {
    private String nome;
    private Boolean caixa;

    public Funcionario(String nome, Boolean caixa) {
        this.nome = nome;
        this.caixa = caixa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean isCaixa() {
        return caixa;
    }

    public void setCaixa(Boolean caixa) {
        this.caixa = caixa;
    }
}
