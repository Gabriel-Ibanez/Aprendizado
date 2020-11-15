
import java.util.Arrays;

public class RedeNeuralMLP {

    private static double TAXA_APRENDIZADO = 0.05; // se for grande pode não convergir. Se for muito pequeno pode demorar para convergir

    private double[][] pesosEntreAsEntradasEACamadaOCulta; // aqui
    private double[] pesosEntreACamadaOcultaEONeuronioDeSaida; // e aqui ficam armazendados o "conhecimento" da rede
    private int nrNeuroniosEntrada;
    private int nrNeuroniosDaCamadaOculta;
    private int epocas = 0;

    // construtor da rede que recebe o número de entradas e número de camadas
    public RedeNeuralMLP (int nrNeuroniosEntrada, int nrNeuroniosDaCamadaOculta) {
        this.nrNeuroniosEntrada = nrNeuroniosEntrada;
        this.nrNeuroniosDaCamadaOculta = nrNeuroniosDaCamadaOculta;
        this.inicializarConexoesSinapticasDaRede();
    }

    private void inicializarConexoesSinapticasDaRede(){
        inicializarConexoesEntreACamadaDeEntradaEACamadaOculta();
        inicializarConexoesEntreACamadaOcultaEONeuronioDeSaida();
    }

    private void inicializarConexoesEntreACamadaDeEntradaEACamadaOculta(){
        pesosEntreAsEntradasEACamadaOCulta = new double[nrNeuroniosDaCamadaOculta][nrNeuroniosEntrada];
        //System.out.println("pesosEntreACamadaDeEntradaEACamadaOCulta.length: " + pesosEntreAsEntradasEACamadaOCulta.length);
        for (int i = 0; i < pesosEntreAsEntradasEACamadaOCulta.length; i++){ // número de neurônios da entrada
            for (int j = 0; j < pesosEntreAsEntradasEACamadaOCulta[i].length; j++){ // número de neurônios da camada oculta
                pesosEntreAsEntradasEACamadaOCulta[i][j] = Math.random();
            }
        }
    }

    private void inicializarConexoesEntreACamadaOcultaEONeuronioDeSaida(){
        pesosEntreACamadaOcultaEONeuronioDeSaida = new double[nrNeuroniosDaCamadaOculta + 1]; // + 1: peso do bias
        for (int i = 0; i < pesosEntreACamadaOcultaEONeuronioDeSaida.length; i++){
            pesosEntreACamadaOcultaEONeuronioDeSaida[i] = Math.random();
        }
    }


    public void treinar (double[][] conjuntoTreinamento, double[] valoresEsperados){
        double erro = 1.0; // como entradas estão entre 0 e 1, o erro máximo possível é 1
        while (( Math.abs(erro) > 0.005) && (epocas < 100000)){ // 0.005 = grau de assertividade de 99,5%
            for (int i = 0; i < conjuntoTreinamento[0].length; i++) { // épocas conta a quantidade de ciclos de treinamento
                double[] entradasParaONeuronioDeSaida = propagarSinalPelaCamadaOculta(conjuntoTreinamento, i);
                double valorSaida = propagarSinalPeloNeuronioDeSaida(entradasParaONeuronioDeSaida);
                erro = calcularErro(valoresEsperados, valorSaida, i);
                double gradiente = getGradienteDeRetropropagacao(valorSaida, erro);
                aprender(conjuntoTreinamento, entradasParaONeuronioDeSaida, gradiente, i);
            }
            epocas++;
            if ((epocas % 1000) == 0 )System.out.print("Treinando... "+ epocas +" épocas. Erro = " + Math.abs(erro) + "\n");
        }
    }

    public double classificar(double[] entrada){

        double r = 0.0;
        if(epocas > 99999) {
            System.out.println("Não foi possível atingir um ponto de convergência, verifique os parâmetros e estrutura da rede.");
        } else {
            double[] saidasDaCamadaOculta = getSaidaClassificacaoDaCamadaOculta(entrada);
            double[] entradasNoNeuronioDeSaida = getEntradasNoNeuronioDeSaida(saidasDaCamadaOculta);
            double y = propagarSinalPeloNeuronioDeSaida(entradasNoNeuronioDeSaida);
            r = Math.round(y);
         //  System.out.println("Saída : "+ y + "\t Valor arrendondado: " + r);
        }
        return r;
    }

    private void aprender(double[][] conjuntoTreinamento, double[] entradasNoNeuronioDeSaida, double gradiente, int i){
        retropopagarErroEntreONeuronioDeSaidaEACamadaOculta(entradasNoNeuronioDeSaida, gradiente);
        retropropagarErroEntreACamadaOcultaEAsEntradas(conjuntoTreinamento, entradasNoNeuronioDeSaida, gradiente, i);
    }

    private double[] propagarSinalPelaCamadaOculta(double[][] conjuntoTreinamento, int i){
        double[] saidasDaCamadaOculta = getSaidaTreinamentoDaCamadaOculta(conjuntoTreinamento,i);
        return getEntradasNoNeuronioDeSaida(saidasDaCamadaOculta);
    }

    private double propagarSinalPeloNeuronioDeSaida(double[] entradasNoNeuronioDeSaida){
        double u = 0;
        for (int j = 0; j < pesosEntreACamadaOcultaEONeuronioDeSaida.length; j++){
            u += entradasNoNeuronioDeSaida[j] * pesosEntreACamadaOcultaEONeuronioDeSaida[j];
        }
        return getFuncaoTransferencia(u);
    }

    private double[] getEntradasNoNeuronioDeSaida(double[] saidasDaCamadaOculta){
        double[] entradasParaONeuronioDeSaida = Arrays.copyOf(saidasDaCamadaOculta,saidasDaCamadaOculta.length + 1); // +1: bias
        entradasParaONeuronioDeSaida[entradasParaONeuronioDeSaida.length - 1] = 1.0; // 1 para o bias
        return entradasParaONeuronioDeSaida;
    }

    private double[] getSaidaTreinamentoDaCamadaOculta(double[][] conjuntoTreinamento, int i){
        double[] saidasDaCamadaOculta = new double[nrNeuroniosDaCamadaOculta]; // vetor das saídas
        for (int j = 0; j < pesosEntreAsEntradasEACamadaOCulta.length; j++){
            double u = 0; //essa variável acumula a soma ponderada
            for (int k = 0; k < pesosEntreAsEntradasEACamadaOCulta[j].length; k++){
                u += conjuntoTreinamento[k][i] * pesosEntreAsEntradasEACamadaOCulta[j][k];
            }
            saidasDaCamadaOculta[j] = getFuncaoTransferencia(u);
        }
        return saidasDaCamadaOculta;
    }

    // método que calcula a soma ponderada das entradas e apresenta a saída de cada neurônio da camada oculta
    private double[] getSaidaClassificacaoDaCamadaOculta(double[] entrada){
        double[] saidasDaCamadaOculta = new double[nrNeuroniosDaCamadaOculta]; // vetor das saídas
        for (int j = 0; j < pesosEntreAsEntradasEACamadaOCulta.length; j++){
            double u = 0; // essa variável acumula a soma ponderada
            for (int k = 0; k < pesosEntreAsEntradasEACamadaOCulta[j].length; k++){
                u += entrada[k] * pesosEntreAsEntradasEACamadaOCulta[j][k];
            }
            saidasDaCamadaOculta[j] = getFuncaoTransferencia(u);
        }
        return saidasDaCamadaOculta;
    }

    private void retropropagarErroEntreACamadaOcultaEAsEntradas (double[][] conjuntoTreinamento, double[] entradasNoNeuronioDeSaida, double gradiente, int i){
        for (int j = 0; j < entradasNoNeuronioDeSaida.length - 1; j++){
            double derivadaFuncaoTransferencia = entradasNoNeuronioDeSaida[j] * (1.0 - entradasNoNeuronioDeSaida[j]); // derivada da Sigmóide
            double sigma = derivadaFuncaoTransferencia * (pesosEntreACamadaOcultaEONeuronioDeSaida[j] * gradiente);
            for (int k = 0; k < pesosEntreAsEntradasEACamadaOCulta[j].length; k++){
                pesosEntreAsEntradasEACamadaOCulta[j][k] += RedeNeuralMLP.TAXA_APRENDIZADO * sigma * conjuntoTreinamento[k][i];
            }
        }
    }

    private void retropopagarErroEntreONeuronioDeSaidaEACamadaOculta (double[] entradasNoNeuronioDeSaida, double gradiente){
        for (int j = 0; j < pesosEntreACamadaOcultaEONeuronioDeSaida.length; j++){
            pesosEntreACamadaOcultaEONeuronioDeSaida[j] += RedeNeuralMLP.TAXA_APRENDIZADO * entradasNoNeuronioDeSaida[j] * gradiente;
        }
    }

    private double getGradienteDeRetropropagacao(double valorSaida, double erro){
        return valorSaida * (1 - valorSaida) * erro;
    }

    // função de ativação escolhida: sigmóide
    private double getFuncaoTransferencia(double u){
        return 1.0 / (1.0 + Math.exp(-u));
    }

    private double calcularErro(double[] valorEsperado, double valorSaida, int i){
        return valorEsperado[i] - valorSaida;
    }

    public void imprimirValoresDosPesos(){
        System.out.printf("\nMostrando os pesos das ligações entre os %s neurônios de entrada e os %s neurônios da camada oculta: \n", nrNeuroniosEntrada, nrNeuroniosDaCamadaOculta);
        for (int i = 0; i < pesosEntreAsEntradasEACamadaOCulta.length; i++){
            for (int j = 0; j < pesosEntreAsEntradasEACamadaOCulta[i].length; j++){
                System.out.println("Pesos["+j+"]"+"["+i+"]: "+pesosEntreAsEntradasEACamadaOCulta[i][j]);
            }
            System.out.println("");
        }

        System.out.printf("\nMostrando os pesos das ligações entre os %s neurônios da camada oculta e o neurônio de saída: \n", nrNeuroniosDaCamadaOculta);
        System.out.printf("\nObs.: o útimo valor é o peso do bias do neurônio de saída!");
        for (int i = 0; i < pesosEntreACamadaOcultaEONeuronioDeSaida.length; i++){
            System.out.println("Peso["+i+"]: "+ pesosEntreACamadaOcultaEONeuronioDeSaida[i]);
        }
    }

    public int getEpocas() {
        return epocas;
    }

}
