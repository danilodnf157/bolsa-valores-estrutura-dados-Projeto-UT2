
public class QuickSort extends Funcoes{
    
    public void gerarQuickSort(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("________________________QUICK SORT________________________");
        System.out.println();
        System.out.println("ORDEM ALFABETICA:");
        System.out.println("MEDIO CASO:");
        criarArquivo(QuickSortTickerTempo(vetor), "b3stocks_ticker_quickSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_quickSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("MELHOR CASO:");
        criarArquivo(QuickSortTickerTempo(vetor), "b3stocks_ticker_quickSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_quickSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("PIOR CASO:");
        criarArquivo(QuickSortTickerTempo(inverterVetor(vetor)), "b3stocks_ticker_quickSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_quickSort_piorCaso.csv\" criado com sucesso.");

        System.out.println();
        System.out.println("VOLUME:");
        System.out.println("MEDIO CASO:");
        criarArquivo(QuickSortVolumeTempo(vetor), "b3stocks_volume_quickSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_quickSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("MELHOR CASO:");
        criarArquivo(QuickSortVolumeTempo(vetor), "b3stocks_volume_quickSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_quickSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("PIOR CASO:");
        criarArquivo(QuickSortVolumeTempo(inverterVetor(vetor)), "b3stocks_volume_quickSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_quickSort_piorCaso.csv\" criado com sucesso.");

        System.out.println();
        System.out.println("VARIACOES DIARIAS:");
        System.out.println("MEDIO CASO:");
        criarArquivo(QuickSortVariacoesTempo(vetor), "b3stocks_fluctuations_quickSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_quickSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("MELHOR CASO:");
        criarArquivo(QuickSortVariacoesTempo(vetor), "b3stocks_fluctuations_quickSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_quickSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("PIOR CASO:");
        criarArquivo(QuickSortVariacoesTempo(inverterVetor(vetor)), "b3stocks_fluctuations_quickSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_quickSort_piorCaso.csv\" criado com sucesso.");
    }
        public Registro[] QuickSortTickerTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();
            QuickSortTicker(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] QuickSortTicker(Registro[] vetor, int inicio, int fim){
            int pivo;

            if(inicio < fim){
                pivo = PartitionTicker(vetor, inicio, fim);

                QuickSortTicker(vetor, inicio, pivo - 1);
                QuickSortTicker(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int PartitionTicker(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if((A[j].getTicker().compareTo(pivo.getTicker()) < 0)){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }

        public Registro[] QuickSortVariacoesTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();
            QuickSortVariacoes(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] QuickSortVariacoes(Registro[] vetor, int inicio, int fim){
            int pivo;

            if(inicio < fim){
                pivo = PartitionVariacoes(vetor, inicio, fim);

                QuickSortVariacoes(vetor, inicio, pivo - 1);
                QuickSortVariacoes(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int PartitionVariacoes(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if((A[j].getHigh() - A[j].getLow()) > (pivo.getHigh() - pivo.getLow())){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }


        public Registro[] QuickSortVolumeTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();
            QuickSortVolume(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] QuickSortVolume(Registro[] vetor, int inicio, int fim){
            int pivo;

            if(inicio < fim){
                pivo = PartitionVolume(vetor, inicio, fim);

                QuickSortVolume(vetor, inicio, pivo - 1);
                QuickSortVolume(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int PartitionVolume(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if(A[j].getVolume() < pivo.getVolume()){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }
            
}
