package bovespa;

public class Main extends Funcoes{

    public static void main(String[] args) {
        
        String caminho = "./b3_stocks_1994_2020.csv";
        String caminho2 = "./b3stocks_T1.csv";
        
        
        TransformarData transformarData = new TransformarData();
        transformarData.transform(caminho);

        FiltrarRegistro filtrarRegistro = new FiltrarRegistro();
        filtrarRegistro.filtrar(caminho2);

        FiltrarMediaDiaria filtrarPorMedia = new FiltrarMediaDiaria();
        filtrarPorMedia.filtrarMediaDiaria(caminho2);
        

        Registro[] baseDeDados = construirVetorRegistro(caminho2);
        //Registro[] baseDeDados = construirVetorMenor(caminhoTeste); //Vetor menor para testar as ordenações

        QuickSort objQuickSort = new QuickSort();
        objQuickSort.gerarQuickSort(baseDeDados);

        MergeSort objMergeSort = new MergeSort();
        objMergeSort.gerarMergeSort(baseDeDados);

        HeapSort objHeapSort = new HeapSort();
        objHeapSort.gerarHeapSort(baseDeDados);

        

    }//Fim do main
}