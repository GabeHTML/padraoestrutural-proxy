import java.util.List;

public class ClienteMercadoProxy implements IClienteMercado {
    private ClienteMercado clienteMercado;
    private int cpf;

    public ClienteMercadoProxy(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public List<String> obterHistoricoConsulta() {
        if (this.clienteMercado == null) {
            this.clienteMercado = new ClienteMercado(this.cpf);
        }
        return this.clienteMercado.obterHistoricoConsulta();
    }

    @Override
    public List<String> obterExtratoDoMercado(Funcionario funcionario) {
        if (!funcionario.isCaixa()) {
            throw new IllegalArgumentException("Acesso negado.");
        }
        if (this.clienteMercado == null) {
            this.clienteMercado = new ClienteMercado(this.cpf);
        }
        return this.clienteMercado.obterExtratoDoMercado(funcionario);
    }
}
