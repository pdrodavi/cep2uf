import java.util.ArrayList;
import java.util.List;

public class CepParaUf {

    public static void main(String[] args) {
        String cep = "01000000"; // Insira o CEP aqui
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

        int cepNumerico = Integer.parseInt(cep.replace("-", "").substring(0, 8));

        List<FaixaCep> faixas = carregarFaixas();

        for (FaixaCep faixa : faixas) {
            if (cepNumerico >= faixa.inicio && cepNumerico <= faixa.fim) {
                return faixa.uf;
            }
        }

        return null; // Retorna null se nenhuma UF corresponder
    }

    public static List<FaixaCep> carregarFaixas() {
        List<FaixaCep> faixas = new ArrayList<>();

        faixas.add(new FaixaCep("AC", 69900000, 69999999));
        faixas.add(new FaixaCep("AL", 57000000, 57999999));
        faixas.add(new FaixaCep("AP", 68900000, 68999999));
        faixas.add(new FaixaCep("AM", 69000000, 69299999));
        faixas.add(new FaixaCep("AM", 69400000, 69899999));
        faixas.add(new FaixaCep("BA", 40000000, 48999999));
        faixas.add(new FaixaCep("CE", 60000000, 63999999));
        faixas.add(new FaixaCep("DF", 70000000, 72799999));
        faixas.add(new FaixaCep("DF", 73000000, 73699999));
        faixas.add(new FaixaCep("ES", 29000000, 29999999));
        faixas.add(new FaixaCep("GO", 72800000, 72999999));
        faixas.add(new FaixaCep("GO", 73700000, 76799999));
        faixas.add(new FaixaCep("MA", 65000000, 65999999));
        faixas.add(new FaixaCep("MT", 78000000, 78899999));
        faixas.add(new FaixaCep("MS", 79000000, 79999999));
        faixas.add(new FaixaCep("MG", 30000000, 39999999));
        faixas.add(new FaixaCep("PA", 66000000, 68899999));
        faixas.add(new FaixaCep("PB", 58000000, 58999999));
        faixas.add(new FaixaCep("PR", 80000000, 87999999));
        faixas.add(new FaixaCep("PE", 50000000, 56999999));
        faixas.add(new FaixaCep("PI", 64000000, 64999999));
        faixas.add(new FaixaCep("RJ", 20000000, 28999999));
        faixas.add(new FaixaCep("RN", 59000000, 59999999));
        faixas.add(new FaixaCep("RS", 90000000, 99999999));
        faixas.add(new FaixaCep("RO", 76800000, 76999999));
        faixas.add(new FaixaCep("RR", 69300000, 69399999));
        faixas.add(new FaixaCep("SC", 88000000, 89999999));
        faixas.add(new FaixaCep("SE", 49000000, 49999999));
        faixas.add(new FaixaCep("SP", 1000000, 19999999));
        faixas.add(new FaixaCep("TO", 77000000, 77999999));

        return faixas;
    }

    static class FaixaCep {
        String uf;
        int inicio;
        int fim;

        FaixaCep(String uf, int inicio, int fim) {
            this.uf = uf;
            this.inicio = inicio;
            this.fim = fim;
        }
    }
}
