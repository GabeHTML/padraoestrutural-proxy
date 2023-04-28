import java.util.List;

public interface IClienteMercado {
    List<String> obterHistoricoConsulta();
    List<String> obterExtratoDoMercado(Funcionario funcionario);
}
