import java.util.HashMap;
import java.util.Map;

public class CepParaUf {

    public static void main(String[] args) {
        String cep = "12345678"; // Insira o CEP aqui
        String uf = identificarUF(cep);

        if (uf != null) {
            System.out.println("A UF correspondente ao CEP " + cep + " é: " + uf);
        } else {
            System.out.println("CEP inválido ou fora das faixas conhecidas.");
        }
    }

    public static String identificarUF(String cep) {
        if (cep == null || cep.length() < 8) {
            return null; // Verifica se o CEP é válido
        }

        int cepPrefixo = Integer.parseInt(cep.substring(0, 5));

        Map<String, String> faixasUF = new HashMap<>();
        // Adiciona faixas de CEP para cada UF
        faixasUF.put("SP", "01000-19999");
        faixasUF.put("RJ", "20000-28999");
        faixasUF.put("MG", "30000-39999");
        faixasUF.put("ES", "29000-29999");
        faixasUF.put("RS", "90000-99999");
        faixasUF.put("PR", "80000-87999");
        faixasUF.put("SC", "88000-89999");
        faixasUF.put("BA", "40000-48999");
        faixasUF.put("PE", "50000-56999");
        faixasUF.put("CE", "60000-63999");
        faixasUF.put("GO", "72800-76799");
        // Adicione outras faixas de CEP conforme necessário

        for (Map.Entry<String, String> entry : faixasUF.entrySet()) {
            String uf = entry.getKey();
            String[] faixa = entry.getValue().split("-");
            int inicio = Integer.parseInt(faixa[0].replace("-", ""));
            int fim = Integer.parseInt(faixa[1].replace("-", ""));

            if (cepPrefixo >= inicio && cepPrefixo <= fim) {
                return uf;
            }
        }

        return null; // Retorna null se nenhuma UF corresponder
    }
}
