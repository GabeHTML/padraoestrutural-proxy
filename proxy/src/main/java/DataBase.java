import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<Integer, ClienteMercado> cliente = new HashMap<>();

    public static ClienteMercado getCliente(Integer cpf) {
        return cliente.get(cpf);
    }

    public static void addCliente(ClienteMercado clienteMercado) {
        clienteMercado.put(clienteMercado.getCpf(), clienteMercado);
    }
}
