import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteMercadoTest {
    @BeforeEach
    void setUp() {
        DataBase.addCliente(new ClienteMercado( 231120,"Miguel" , "24123456","Centro, Miguel",List.of("Consulta de Saldo - 01/01/2023", "Consulta Transferencia - 01/02/2023"),
                List.of("Extrato Realizado", "Extrato de 1000")));;
        DataBase.addCliente(new ClienteMercado( 234567,"Gabe" , "24256700","Centro, Vassouras",List.of("Consulta de Saldo - 10/01/2023", "Consulta Transferencia - 10/02/2023"),
                List.of("Extrato Realizado", "Extrato de 1100")));;
    }

    @Test
    void deveRetornarHistoricoDeConsultasDoCliente() {
        ClienteMercadoProxy cliente = new ClienteMercadoProxy(234567);
        cliente.obterHistoricoConsulta();

        assertEquals(List.of("Consulta de Saldo - 10/01/2023", "Consulta Transferencia - 10/02/2023"),
                cliente.obterHistoricoConsulta());
    }
    @Test
    void deveRetornarExtratoDoMercado() {
        Funcionario funcionario = new Funcionario("Maria", true);
        ClienteMercadoProxy cliente = new ClienteMercadoProxy(231120);
        cliente.obterExtratoDoMercado(funcionario);

        assertEquals(List.of("Consulta de Saldo - 01/03/2023", "Consulta Transferencia - 02/04/2023"),
                cliente.obterExtratoDoMercado(funcionario));
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoAutorizadoConsultarExtrato() {
        try {
            Funcionario funcionario = new Funcionario("Mel", false);
            ClienteMercadoProxy cliente = new ClienteMercadoProxy(231120);
            cliente.obterExtratoDoMercado(funcionario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Acesso negado.", e.getMessage());
        }
    }
}
