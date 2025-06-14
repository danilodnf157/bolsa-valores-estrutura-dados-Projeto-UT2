package bovespa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import estruturas.HashTable;
import estruturas.ListaLigada;

public class FiltrarMediaDiaria extends Funcoes {

    public void filtrarMediaDiaria(String caminho) {
        try (BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho)));
             PrintWriter writer = new PrintWriter(new FileWriter("data/b3stocks_T1_Filtrado.csv"))) {
            String colunas = arq.readLine();
            writer.println(colunas);

            HashTable ht = new HashTable(1024);
            Registro reg;
            while ((reg = lerRegistro(arq)) != null) {
                ht.put(reg.getData(), reg);
            }

            for (Date d : ht.keySet()) {
                ListaLigada grupo = ht.get(d);
                float soma = 0;
                int count = 0;
                for (Registro r : grupo) {
                    soma += r.getVolume();
                    count++;
                }
                float media = soma / count;
                for (Registro r : grupo) {
                    if (r.getVolume() > media) writer.println(r.toString());
                }
            }
            System.out.println("b3stocks_T1_Filtrado.csv criado em data/");
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    private Registro lerRegistro(BufferedReader arq) throws IOException {
        String linha = arq.readLine();
        if (linha == null) return null;
        String[] dados = separarDados(linha);
        Date data = parseDate(dados[0]);
        return new Registro(data, dados[1], Float.parseFloat(dados[2]),
                            Float.parseFloat(dados[3]), Float.parseFloat(dados[4]),
                            Float.parseFloat(dados[5]), Float.parseFloat(dados[6]), linha);
    }
}
