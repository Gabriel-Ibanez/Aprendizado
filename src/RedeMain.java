import java.util.*;


public class RedeMain {

    // Conjunto de treino 1
    private static double[][] CONJUNTO_TREINAMENTO1 = {
            {0.0, 0.0, 1.0, 1.0},
            {0.0, 1.0, 0.0, 1.0},
            {1.0, 1.0, 1.0, 1.0}, // bias
    };
//     resposta treino 1:
            private static double[] VALORES_ESPERADOS1 = {0.0, 0.0, 0.0, 1.0};


    static ArrayList<double[]> listaDeVetoresTesteAptos = new ArrayList<>();
    static ArrayList<double[]> listaDeVetoresTesteNaoAptos = new ArrayList<>();
    static ArrayList<double[]> listaDeVetoresTesteCandidatosAleatorios = new ArrayList<>();


    static int numeroDeAptos = 0;
    static int numeroDeNaoAptos = 0;
    static int testeAptos = 0;
    static int testeNaoAptos = 0;
    static int testeCandidatosAleatorios = 0;


    public static void main(String[] args) {




        ArrayList<Usuario> listaDeCandidatosAleatorios = new ArrayList<>();

        Scanner scanner1 = new Scanner(System.in);

//        int nrNeuroniosEntrada = 3;
//        int nrNeuroniosCamadaOculta = 3;

        int nrNeuroniosEntrada = 38;
        int nrNeuroniosCamadaOculta = 26;

// teste 1:
//        numeroDeAptos = 20;
//        numeroDeNaoAptos = 10;
//        testeAptos = 5;
//        testeNaoAptos = 5;
//        testeCandidatosAleatorios = 5;

        // teste 2:
        numeroDeAptos = 1000;
        numeroDeNaoAptos = 500;
        testeAptos = 20;
        testeNaoAptos = 20;
        testeCandidatosAleatorios = 50;



        System.out.println("\nProjeto Integrador - Rede Neural - Gabriel Ibañez - 1812130004\n");

        ArrayList<Usuario> listaDeAptos = new ArrayList<>();
        ArrayList<Usuario> listaDeNaoAptos = new ArrayList<>();
        double VALORES_ESPERADOS3[] = new double[numeroDeAptos + numeroDeNaoAptos];


        for (int i = 0; i < numeroDeAptos; i++) { // gerando vagas - aptos
            Usuario u1 = new Usuario(false, true);
            listaDeAptos.add(u1);
        }

        for (int i = 0; i < numeroDeNaoAptos; i++) { // gerando não aptos
            Usuario u2 = new Usuario(false,  false);
            listaDeNaoAptos.add(u2);
        }

        for (int i = 0; i < testeCandidatosAleatorios; i++) {
            Usuario u1 = new Usuario(false, (i % 2 == 0));
            listaDeCandidatosAleatorios.add(u1);
        }

        double[][] CONJUNTO_TREINAMENTO3 = new double[38][listaDeAptos.size() + listaDeNaoAptos.size()];

        listaDeAptos.set(3, listaDeNaoAptos.get(3)); // Uum mesmo candidato definido como apto e logo inapto

        // preenchendo os dados para aptos:
        for (int i = 0; i < listaDeAptos.size(); i++) {
            CONJUNTO_TREINAMENTO3[0][i] = listaDeAptos.get(i).getVaga() / 4.0;
            CONJUNTO_TREINAMENTO3[1][i] = listaDeAptos.get(i).getPretensaoSalarial() / 5.0;
            CONJUNTO_TREINAMENTO3[2][i] = listaDeAptos.get(i).getTempoAteOTrabalho() / 5.0;
            CONJUNTO_TREINAMENTO3[3][i] = listaDeAptos.get(i).getExperiencia() / 5.0;
            CONJUNTO_TREINAMENTO3[4][i] = listaDeAptos.get(i).getTempoNaUltimaEmpresa() / 5.0;
            CONJUNTO_TREINAMENTO3[5][i] = listaDeAptos.get(i).getOcupacaoAtual() / 2.0;
            CONJUNTO_TREINAMENTO3[6][i] = listaDeAptos.get(i).getGrauEscolaridade() / 4.0;
            CONJUNTO_TREINAMENTO3[7][i] = listaDeAptos.get(i).getCursoQueEstaEstudando() / 85.0;
            CONJUNTO_TREINAMENTO3[8][i] = listaDeAptos.get(i).getSemestreNaFaculdade() / 10.0;
            CONJUNTO_TREINAMENTO3[9][i] = listaDeAptos.get(i).getTipoDeFaculdade() / 4.0;
            CONJUNTO_TREINAMENTO3[10][i] = listaDeAptos.get(i).getSexo() / 1.0;
            CONJUNTO_TREINAMENTO3[11][i] = listaDeAptos.get(i).getFaixaEtaria() / 5.0;
            CONJUNTO_TREINAMENTO3[12][i] = listaDeAptos.get(i).getNacionalidade() / 1.0;
            CONJUNTO_TREINAMENTO3[13][i] = listaDeAptos.get(i).getEstadoCivil() / 2.0;
            CONJUNTO_TREINAMENTO3[14][i] = listaDeAptos.get(i).getNumeroDeFilhos() / 2.0;
            CONJUNTO_TREINAMENTO3[15][i] = listaDeAptos.get(i).getTemCarroProrio() / 1.0;
            CONJUNTO_TREINAMENTO3[16][i] = listaDeAptos.get(i).getTipoCarteiraMotorista() / 4.0;

            CONJUNTO_TREINAMENTO3[17][i] = listaDeAptos.get(i).getC1() / 50.0;
            CONJUNTO_TREINAMENTO3[18][i] = listaDeAptos.get(i).getC2() / 50.0;
            CONJUNTO_TREINAMENTO3[19][i] = listaDeAptos.get(i).getC3() / 50.0;
            CONJUNTO_TREINAMENTO3[20][i] = listaDeAptos.get(i).getC4() / 50.0;
            CONJUNTO_TREINAMENTO3[21][i] = listaDeAptos.get(i).getC5() / 50.0;
            CONJUNTO_TREINAMENTO3[22][i] = listaDeAptos.get(i).getC6() / 50.0;
            CONJUNTO_TREINAMENTO3[23][i] = listaDeAptos.get(i).getC7() / 50.0;
            CONJUNTO_TREINAMENTO3[24][i] = listaDeAptos.get(i).getC8() / 50.0;
            CONJUNTO_TREINAMENTO3[25][i] = listaDeAptos.get(i).getC9() / 50.0;
            CONJUNTO_TREINAMENTO3[26][i] = listaDeAptos.get(i).getC10() / 50.0;
            CONJUNTO_TREINAMENTO3[27][i] = listaDeAptos.get(i).getC11() / 50.0;
            CONJUNTO_TREINAMENTO3[28][i] = listaDeAptos.get(i).getC12() / 50.0;
            CONJUNTO_TREINAMENTO3[29][i] = listaDeAptos.get(i).getC13() / 50.0;
            CONJUNTO_TREINAMENTO3[30][i] = listaDeAptos.get(i).getC14() / 50.0;
            CONJUNTO_TREINAMENTO3[31][i] = listaDeAptos.get(i).getC15() / 50.0;
            CONJUNTO_TREINAMENTO3[32][i] = listaDeAptos.get(i).getC16() / 50.0;
            CONJUNTO_TREINAMENTO3[33][i] = listaDeAptos.get(i).getC17() / 50.0;
            CONJUNTO_TREINAMENTO3[34][i] = listaDeAptos.get(i).getC18() / 50.0;
            CONJUNTO_TREINAMENTO3[35][i] = listaDeAptos.get(i).getC19() / 50.0;
            CONJUNTO_TREINAMENTO3[36][i] = listaDeAptos.get(i).getC20() / 50.0;

            CONJUNTO_TREINAMENTO3[37][i] = 1.0; //bias
        }

        // preenchendo os dados para não-aptos:
        for (int i = 0; i < listaDeNaoAptos.size(); i++) {
            CONJUNTO_TREINAMENTO3[0][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getVaga() / 4.0;
            CONJUNTO_TREINAMENTO3[1][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getPretensaoSalarial() / 5.0;
            CONJUNTO_TREINAMENTO3[2][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getTempoAteOTrabalho() / 5.0;
            CONJUNTO_TREINAMENTO3[3][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getExperiencia() / 5.0;
            CONJUNTO_TREINAMENTO3[4][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getTempoNaUltimaEmpresa() / 5.0;
            CONJUNTO_TREINAMENTO3[5][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getOcupacaoAtual() / 2.0;
            CONJUNTO_TREINAMENTO3[6][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getGrauEscolaridade() / 4.0;
            CONJUNTO_TREINAMENTO3[7][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getCursoQueEstaEstudando() / 85.0;
            CONJUNTO_TREINAMENTO3[8][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getSemestreNaFaculdade() / 10.0;
            CONJUNTO_TREINAMENTO3[9][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getTipoDeFaculdade() / 4.0;
            CONJUNTO_TREINAMENTO3[10][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getSexo() / 1.0;
            CONJUNTO_TREINAMENTO3[11][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getFaixaEtaria() / 5.0;
            CONJUNTO_TREINAMENTO3[12][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getNacionalidade() / 1.0;
            CONJUNTO_TREINAMENTO3[13][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getEstadoCivil() / 2.0;
            CONJUNTO_TREINAMENTO3[14][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getNumeroDeFilhos() / 2.0;
            CONJUNTO_TREINAMENTO3[15][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getTemCarroProrio() / 1.0;
            CONJUNTO_TREINAMENTO3[16][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getTipoCarteiraMotorista() / 4.0;

            CONJUNTO_TREINAMENTO3[17][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC1() / 50.0;
            CONJUNTO_TREINAMENTO3[18][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC2() / 50.0;
            CONJUNTO_TREINAMENTO3[19][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC3() / 50.0;
            CONJUNTO_TREINAMENTO3[20][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC4() / 50.0;
            CONJUNTO_TREINAMENTO3[21][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC5() / 50.0;
            CONJUNTO_TREINAMENTO3[22][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC6() / 50.0;
            CONJUNTO_TREINAMENTO3[23][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC7() / 50.0;
            CONJUNTO_TREINAMENTO3[24][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC8() / 50.0;
            CONJUNTO_TREINAMENTO3[25][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC9() / 50.0;
            CONJUNTO_TREINAMENTO3[26][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC10() / 50.0;
            CONJUNTO_TREINAMENTO3[27][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC11() / 50.0;
            CONJUNTO_TREINAMENTO3[28][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC12() / 50.0;
            CONJUNTO_TREINAMENTO3[29][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC13() / 50.0;
            CONJUNTO_TREINAMENTO3[30][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC14() / 50.0;
            CONJUNTO_TREINAMENTO3[31][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC15() / 50.0;
            CONJUNTO_TREINAMENTO3[32][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC16() / 50.0;
            CONJUNTO_TREINAMENTO3[33][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC17() / 50.0;
            CONJUNTO_TREINAMENTO3[34][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC18() / 50.0;
            CONJUNTO_TREINAMENTO3[35][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC19() / 50.0;
            CONJUNTO_TREINAMENTO3[36][listaDeAptos.size() + i] = listaDeNaoAptos.get(i).getC20() / 50.0;
            CONJUNTO_TREINAMENTO3[37][listaDeAptos.size() + i] = 1.0; //bias

        }

        // preenchendo os vetor Resultados com aptos (resultado esperado = 1)
        for (int i = 0; i < numeroDeAptos; i++) {
            VALORES_ESPERADOS3[i] = 1;
        }

        // preenchendo os vetor Resultados com não-aptos (resultado esperado = 0)
        for (int i = 0; i < numeroDeNaoAptos; i++) {
            VALORES_ESPERADOS3[numeroDeAptos + i] = 0;
        }

        //preenchendo os vetores para testes
        for (int numero = 0; numero < numeroDeAptos; numero++) {
            double[] vetorParaTesteApto = new double[38];
            vetorParaTesteApto[0] = listaDeAptos.get(numero).getVaga() / 4.0;
            vetorParaTesteApto[1] = listaDeAptos.get(numero).getPretensaoSalarial() / 5.0;
            vetorParaTesteApto[2] = listaDeAptos.get(numero).getTempoAteOTrabalho() / 5.0;
            vetorParaTesteApto[3] = listaDeAptos.get(numero).getExperiencia() / 5.0;
            vetorParaTesteApto[4] = listaDeAptos.get(numero).getTempoNaUltimaEmpresa() / 5.0;
            vetorParaTesteApto[5] = listaDeAptos.get(numero).getOcupacaoAtual() / 2.0;
            vetorParaTesteApto[6] = listaDeAptos.get(numero).getGrauEscolaridade() / 4.0;
            vetorParaTesteApto[7] = listaDeAptos.get(numero).getCursoQueEstaEstudando() / 85.0;
            vetorParaTesteApto[8] = listaDeAptos.get(numero).getSemestreNaFaculdade() / 10.0;
            vetorParaTesteApto[9] = listaDeAptos.get(numero).getTipoDeFaculdade() / 4.0;
            vetorParaTesteApto[10] = listaDeAptos.get(numero).getSexo() / 1.0;
            vetorParaTesteApto[11] = listaDeAptos.get(numero).getFaixaEtaria() / 5.0;
            vetorParaTesteApto[12] = listaDeAptos.get(numero).getNacionalidade() / 1.0;
            vetorParaTesteApto[13] = listaDeAptos.get(numero).getEstadoCivil() / 2.0;
            vetorParaTesteApto[14] = listaDeAptos.get(numero).getNumeroDeFilhos() / 2.0;
            vetorParaTesteApto[15] = listaDeAptos.get(numero).getTemCarroProrio() / 1.0;
            vetorParaTesteApto[16] = listaDeAptos.get(numero).getTipoCarteiraMotorista() / 4.0;

            vetorParaTesteApto[17] = listaDeAptos.get(numero).getC1() / 50.0;
            vetorParaTesteApto[18] = listaDeAptos.get(numero).getC2() / 50.0;
            vetorParaTesteApto[19] = listaDeAptos.get(numero).getC3() / 50.0;
            vetorParaTesteApto[20] = listaDeAptos.get(numero).getC4() / 50.0;
            vetorParaTesteApto[21] = listaDeAptos.get(numero).getC5() / 50.0;
            vetorParaTesteApto[22] = listaDeAptos.get(numero).getC6() / 50.0;
            vetorParaTesteApto[23] = listaDeAptos.get(numero).getC7() / 50.0;
            vetorParaTesteApto[24] = listaDeAptos.get(numero).getC8() / 50.0;
            vetorParaTesteApto[25] = listaDeAptos.get(numero).getC9() / 50.0;
            vetorParaTesteApto[26] = listaDeAptos.get(numero).getC10() / 50.0;
            vetorParaTesteApto[27] = listaDeAptos.get(numero).getC11() / 50.0;
            vetorParaTesteApto[28] = listaDeAptos.get(numero).getC12() / 50.0;
            vetorParaTesteApto[29] = listaDeAptos.get(numero).getC13() / 50.0;
            vetorParaTesteApto[30] = listaDeAptos.get(numero).getC14() / 50.0;
            vetorParaTesteApto[31] = listaDeAptos.get(numero).getC15() / 50.0;
            vetorParaTesteApto[32] = listaDeAptos.get(numero).getC16() / 50.0;
            vetorParaTesteApto[33] = listaDeAptos.get(numero).getC17() / 50.0;
            vetorParaTesteApto[34] = listaDeAptos.get(numero).getC18() / 50.0;
            vetorParaTesteApto[35] = listaDeAptos.get(numero).getC19() / 50.0;
            vetorParaTesteApto[36] = listaDeAptos.get(numero).getC20() / 50.0;

            vetorParaTesteApto[37] = 1.0; //bias
            listaDeVetoresTesteAptos.add(numero, vetorParaTesteApto);
        }
        for (int numero = 0; numero < numeroDeNaoAptos; numero++) {

            //System.out.println("i =  " + i);
            double[] vetorParaTesteNaoApto = new double[38];
            vetorParaTesteNaoApto[0] = listaDeNaoAptos.get(numero).getVaga() / 4.0;
            vetorParaTesteNaoApto[1] = listaDeNaoAptos.get(numero).getPretensaoSalarial() / 5.0;
            vetorParaTesteNaoApto[2] = listaDeNaoAptos.get(numero).getTempoAteOTrabalho() / 5.0;
            vetorParaTesteNaoApto[3] = listaDeNaoAptos.get(numero).getExperiencia() / 5.0;
            vetorParaTesteNaoApto[4] = listaDeNaoAptos.get(numero).getTempoNaUltimaEmpresa() / 5.0;
            vetorParaTesteNaoApto[5] = listaDeNaoAptos.get(numero).getOcupacaoAtual() / 2.0;
            vetorParaTesteNaoApto[6] = listaDeNaoAptos.get(numero).getGrauEscolaridade() / 4.0;
            vetorParaTesteNaoApto[7] = listaDeNaoAptos.get(numero).getCursoQueEstaEstudando() / 85.0;
            vetorParaTesteNaoApto[8] = listaDeNaoAptos.get(numero).getSemestreNaFaculdade() / 10.0;
            vetorParaTesteNaoApto[9] = listaDeNaoAptos.get(numero).getTipoDeFaculdade() / 4.0;
            vetorParaTesteNaoApto[10] = listaDeNaoAptos.get(numero).getSexo() / 1.0;
            vetorParaTesteNaoApto[11] = listaDeNaoAptos.get(numero).getFaixaEtaria() / 5.0;
            vetorParaTesteNaoApto[12] = listaDeNaoAptos.get(numero).getNacionalidade() / 1.0;
            vetorParaTesteNaoApto[13] = listaDeNaoAptos.get(numero).getEstadoCivil() / 2.0;
            vetorParaTesteNaoApto[14] = listaDeNaoAptos.get(numero).getNumeroDeFilhos() / 2.0;
            vetorParaTesteNaoApto[15] = listaDeNaoAptos.get(numero).getTemCarroProrio() / 1.0;
            vetorParaTesteNaoApto[16] = listaDeNaoAptos.get(numero).getTipoCarteiraMotorista() / 4.0;

            vetorParaTesteNaoApto[17] = listaDeNaoAptos.get(numero).getC1() / 50.0;
            vetorParaTesteNaoApto[18] = listaDeNaoAptos.get(numero).getC2() / 50.0;
            vetorParaTesteNaoApto[19] = listaDeNaoAptos.get(numero).getC3() / 50.0;
            vetorParaTesteNaoApto[20] = listaDeNaoAptos.get(numero).getC4() / 50.0;
            vetorParaTesteNaoApto[21] = listaDeNaoAptos.get(numero).getC5() / 50.0;
            vetorParaTesteNaoApto[22] = listaDeNaoAptos.get(numero).getC6() / 50.0;
            vetorParaTesteNaoApto[23] = listaDeNaoAptos.get(numero).getC7() / 50.0;
            vetorParaTesteNaoApto[24] = listaDeNaoAptos.get(numero).getC8() / 50.0;
            vetorParaTesteNaoApto[25] = listaDeNaoAptos.get(numero).getC9() / 50.0;
            vetorParaTesteNaoApto[26] = listaDeNaoAptos.get(numero).getC10() / 50.0;
            vetorParaTesteNaoApto[27] = listaDeNaoAptos.get(numero).getC11() / 50.0;
            vetorParaTesteNaoApto[28] = listaDeNaoAptos.get(numero).getC12() / 50.0;
            vetorParaTesteNaoApto[29] = listaDeNaoAptos.get(numero).getC13() / 50.0;
            vetorParaTesteNaoApto[30] = listaDeNaoAptos.get(numero).getC14() / 50.0;
            vetorParaTesteNaoApto[31] = listaDeNaoAptos.get(numero).getC15() / 50.0;
            vetorParaTesteNaoApto[32] = listaDeNaoAptos.get(numero).getC16() / 50.0;
            vetorParaTesteNaoApto[33] = listaDeNaoAptos.get(numero).getC17() / 50.0;
            vetorParaTesteNaoApto[34] = listaDeNaoAptos.get(numero).getC18() / 50.0;
            vetorParaTesteNaoApto[35] = listaDeNaoAptos.get(numero).getC19() / 50.0;
            vetorParaTesteNaoApto[36] = listaDeNaoAptos.get(numero).getC20() / 50.0;

            vetorParaTesteNaoApto[37] = 1.0; //bias
            listaDeVetoresTesteNaoAptos.add(numero, vetorParaTesteNaoApto);
        }
        for (int numero = 0; numero < testeCandidatosAleatorios; numero++) {

            //System.out.println("i =  " + i);
            double[] vetorParaTesteCandidatosAleatorios = new double[38];
            vetorParaTesteCandidatosAleatorios[0] = listaDeCandidatosAleatorios.get(numero).getVaga() / 4.0;
            vetorParaTesteCandidatosAleatorios[1] = listaDeCandidatosAleatorios.get(numero).getPretensaoSalarial() / 5.0;
            vetorParaTesteCandidatosAleatorios[2] = listaDeCandidatosAleatorios.get(numero).getTempoAteOTrabalho() / 5.0;
            vetorParaTesteCandidatosAleatorios[3] = listaDeCandidatosAleatorios.get(numero).getExperiencia() / 5.0;
            vetorParaTesteCandidatosAleatorios[4] = listaDeCandidatosAleatorios.get(numero).getTempoNaUltimaEmpresa() / 5.0;
            vetorParaTesteCandidatosAleatorios[5] = listaDeCandidatosAleatorios.get(numero).getOcupacaoAtual() / 2.0;
            vetorParaTesteCandidatosAleatorios[6] = listaDeCandidatosAleatorios.get(numero).getGrauEscolaridade() / 4.0;
            vetorParaTesteCandidatosAleatorios[7] = listaDeCandidatosAleatorios.get(numero).getCursoQueEstaEstudando() / 85.0;
            vetorParaTesteCandidatosAleatorios[8] = listaDeCandidatosAleatorios.get(numero).getSemestreNaFaculdade() / 10.0;
            vetorParaTesteCandidatosAleatorios[9] = listaDeCandidatosAleatorios.get(numero).getTipoDeFaculdade() / 4.0;
            vetorParaTesteCandidatosAleatorios[10] = listaDeCandidatosAleatorios.get(numero).getSexo() / 1.0;
            vetorParaTesteCandidatosAleatorios[11] = listaDeCandidatosAleatorios.get(numero).getFaixaEtaria() / 5.0;
            vetorParaTesteCandidatosAleatorios[12] = listaDeCandidatosAleatorios.get(numero).getNacionalidade() / 1.0;
            vetorParaTesteCandidatosAleatorios[13] = listaDeCandidatosAleatorios.get(numero).getEstadoCivil() / 2.0;
            vetorParaTesteCandidatosAleatorios[14] = listaDeCandidatosAleatorios.get(numero).getNumeroDeFilhos() / 2.0;
            vetorParaTesteCandidatosAleatorios[15] = listaDeCandidatosAleatorios.get(numero).getTemCarroProrio() / 1.0;
            vetorParaTesteCandidatosAleatorios[16] = listaDeCandidatosAleatorios.get(numero).getTipoCarteiraMotorista() / 4.0;

            vetorParaTesteCandidatosAleatorios[17] = listaDeCandidatosAleatorios.get(numero).getC1() / 50.0;
            vetorParaTesteCandidatosAleatorios[18] = listaDeCandidatosAleatorios.get(numero).getC2() / 50.0;
            vetorParaTesteCandidatosAleatorios[19] = listaDeCandidatosAleatorios.get(numero).getC3() / 50.0;
            vetorParaTesteCandidatosAleatorios[20] = listaDeCandidatosAleatorios.get(numero).getC4() / 50.0;
            vetorParaTesteCandidatosAleatorios[21] = listaDeCandidatosAleatorios.get(numero).getC5() / 50.0;
            vetorParaTesteCandidatosAleatorios[22] = listaDeCandidatosAleatorios.get(numero).getC6() / 50.0;
            vetorParaTesteCandidatosAleatorios[23] = listaDeCandidatosAleatorios.get(numero).getC7() / 50.0;
            vetorParaTesteCandidatosAleatorios[24] = listaDeCandidatosAleatorios.get(numero).getC8() / 50.0;
            vetorParaTesteCandidatosAleatorios[25] = listaDeCandidatosAleatorios.get(numero).getC9() / 50.0;
            vetorParaTesteCandidatosAleatorios[26] = listaDeCandidatosAleatorios.get(numero).getC10() / 50.0;
            vetorParaTesteCandidatosAleatorios[27] = listaDeCandidatosAleatorios.get(numero).getC11() / 50.0;
            vetorParaTesteCandidatosAleatorios[28] = listaDeCandidatosAleatorios.get(numero).getC12() / 50.0;
            vetorParaTesteCandidatosAleatorios[29] = listaDeCandidatosAleatorios.get(numero).getC13() / 50.0;
            vetorParaTesteCandidatosAleatorios[30] = listaDeCandidatosAleatorios.get(numero).getC14() / 50.0;
            vetorParaTesteCandidatosAleatorios[31] = listaDeCandidatosAleatorios.get(numero).getC15() / 50.0;
            vetorParaTesteCandidatosAleatorios[32] = listaDeCandidatosAleatorios.get(numero).getC16() / 50.0;
            vetorParaTesteCandidatosAleatorios[33] = listaDeCandidatosAleatorios.get(numero).getC17() / 50.0;
            vetorParaTesteCandidatosAleatorios[34] = listaDeCandidatosAleatorios.get(numero).getC18() / 50.0;
            vetorParaTesteCandidatosAleatorios[35] = listaDeCandidatosAleatorios.get(numero).getC19() / 50.0;
            vetorParaTesteCandidatosAleatorios[36] = listaDeCandidatosAleatorios.get(numero).getC20() / 50.0;

            vetorParaTesteCandidatosAleatorios[37] = 1.0; //bias
            listaDeVetoresTesteCandidatosAleatorios.add(numero, vetorParaTesteCandidatosAleatorios);
        }


        RedeNeuralMLP rede = new RedeNeuralMLP(nrNeuroniosEntrada, nrNeuroniosCamadaOculta);
        System.out.println("Teste antes do treinamento (" + rede.getEpocas() + " épocas):");
        RedeMain.imprimirTesteDeClassificacao(rede);

//        rede.treinar(CONJUNTO_TREINAMENTO1, VALORES_ESPERADOS1); // TREINAMENTO
        rede.treinar(CONJUNTO_TREINAMENTO3, VALORES_ESPERADOS3); //*

        System.out.println("\nRede Treinada! Total de " + rede.getEpocas() + " épocas.");
        System.out.print("\nDigite qualquer número para fazer o teste depois do treinamento: "); //*

        Scanner scanner3 = new Scanner(System.in);
        int pausa2 = scanner3.nextInt();

        RedeMain.imprimirTesteDeClassificacao(rede); //*


        System.out.println(" Fim!");


    }

    public static boolean naoTemRestoZero(Integer dividendo, Integer divisor){
        if (dividendo%divisor == 0) {
            return false;
        };
        return true;
    }

    private static void imprimirTesteDeClassificacao(RedeNeuralMLP rede) {
////        teste treino 1.
//        rede.classificar(new double[] {0.0, 0.0, 1.0});
//        rede.classificar(new double[] {0.0, 1.0, 1.0});
//        rede.classificar(new double[] {1.0, 0.0, 1.0});
//        rede.classificar(new double[] {1.0, 1.0, 1.0});



//
//
        System.out.print("\nTESTE");
        System.out.print("\nInserção de dados "+ numeroDeAptos + "\t candidatos aptos");
        System.out.print("\nInserção de dados "+ numeroDeNaoAptos + "\t candidatos não-aptos");

        System.out.print("\n" + testeAptos + " candidatos aptos:\n");
        double d = testeAptos / 1.0, r = 0.0;
        int acertos = 0;
        for (int i = 0; i < testeAptos; i++) {
            double[] vetorParaTesteAux = new double[38];
            vetorParaTesteAux = listaDeVetoresTesteAptos.get(i);
            r = rede.classificar(vetorParaTesteAux);
            if (r == 1.0) acertos++;
        }
        System.out.println("taxa de acerto de " + (acertos / d) * 100 + "%\n");

        acertos = 0;

        System.out.print(testeNaoAptos + " candidatos não aptos:\n");
        d = testeNaoAptos / 1.0;
        for (int i = 0; i < testeNaoAptos; i++) {
            double[] vetorParaTesteAux = new double[38];
            vetorParaTesteAux = listaDeVetoresTesteNaoAptos.get(i);
            r = rede.classificar(vetorParaTesteAux);
            if (r == 0.0) acertos++;
        }
        System.out.println("taxa de acerto de " + (acertos / d) * 100 + "%\n");

        int aptos = 0;
        int naoAptos = 0;
        System.out.print(testeCandidatosAleatorios + " candidatos aleatórios:\n");
        d = testeCandidatosAleatorios / 1.0;
        for (int i = 0; i < testeCandidatosAleatorios; i++) {
            double[] vetorParaTesteAux = new double[38];
            vetorParaTesteAux = listaDeVetoresTesteCandidatosAleatorios.get(i);
            r = rede.classificar(vetorParaTesteAux);
            if (r == 0.0) {aptos++;} else {naoAptos++;}
        }
        System.out.println("Aptos " + aptos + "\t Não aptos: " + naoAptos+"\n");



    }

}

