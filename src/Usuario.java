import java.text.DecimalFormat;
import java.util.Random;

public class Usuario {

    // dados para registro do usuario:
    int id;
    boolean tipoUsuario; // false: Empregador  true: Candidato
    String nome;
    int nacimento; // usado par calcular faixaEtaria;
    int idFoto; // foto da logomarca da empresa / foto do candidato
    String telefone1;
    String telefone2;
    String eMail;
    String CEP;
    String nomeEmpresaOuFaculdade; // nome da empresa / nome da faculdade foto do candidato


    String descriçãoDaVaga;
    String horarioDoTrabalho;
    String cargaHoraria;
    String tempoPrevistoDoContrato;
    String local;
    String observacoesSobrAVaga;

    String beneficios;
    // Auxilio transporte
    // Auxílio refeição
    // Plano de saúde
    // Seguro de vida
    // Estacionamento
    // Assistencia odontológica
    // Participação nos lucros (anual)
    // Ginástica laboral
    // Programa de treinamento
    // Restaurante interno
    // hospedagem no trabalho



    // dados para a rede neural CURRÍCULO DO CANDIDATO / REQUISITOS PARA CONTRATAÇÃO

    int vaga; // faixa: 0 a 4
    int pretensaoSalarial; // faixa: 0 a 5


    int tempoAteOTrabalho; // faixa: 0 a 5

    int experiencia; // faixa: 0 a 5
    int tempoNaUltimaEmpresa; // faixa: 0 a 5

    int ocupacaoAtual; // faixa: 0 a 2
    int grauEscolaridade; // faixa: 0 a 4
    int cursoQueEstaEstudando; // faixa: 0 a 85
    int semestreNaFaculdade; // faixa: 0 a 10
    int tipoDeFaculdade; // faixa: 0 a 4



    int sexo; // faixa: 0 a 1
    int faixaEtaria; // faixa: 0 a 5
    int nacionalidade; // faixa: 0 a 1
    int estadoCivil; // faixa: 0 a 2
    int numeroDeFilhos; // faixa: 0 a 2
    int temCarroProrio; // faixa: 0 a 1
    int tipoCarteiraMotorista; // faixa: 0 a 4


    int c1; // faixa: 0 a 50
    int c2; // faixa: 0 a 50
    int c3; // faixa: 0 a 50
    int c4; // faixa: 0 a 50
    int c5; // faixa: 0 a 50
    int c6; // faixa: 0 a 50
    int c7; // faixa: 0 a 50
    int c8; // faixa: 0 a 50
    int c9; // faixa: 0 a 50
    int c10; // faixa: 0 a 50
    int c11; // faixa: 0 a 50
    int c12; // faixa: 0 a 50
    int c13; // faixa: 0 a 50
    int c14; // faixa: 0 a 50
    int c15; // faixa: 0 a 50
    int c16; // faixa: 0 a 50
    int c17; // faixa: 0 a 50
    int c18; // faixa: 0 a 50
    int c19; // faixa: 0 a 50
    int c20; // faixa: 0 a 50


public Usuario (boolean tipoUsuario, boolean apto){
    Random random= new Random();

    this.id = 2019000 +random.nextInt(500);
    this.tipoUsuario = tipoUsuario;
    this.nome = "Nome"+random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10);

    this.nacimento = 10;
    this.idFoto = 22222+random.nextInt(500);

    String telefone1 = "Tel1."+"61-9-"+"9"
            +random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10)+"-"
            +random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10);
    String telefone2 = "Tel2."+"61-3-"+"2"
            +random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10)+"-"
            +random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10);
    String eMail= "abc" +
            +random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10)+"@"
            +random.nextInt(10)+""+random.nextInt(10)+".com.br";
    String CEP= "7"
            +random.nextInt(10)+"."
            +random.nextInt(10)+""+random.nextInt(10)+""
            +random.nextInt(10)+""+random.nextInt(10)+"-"
            +random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10);

    if (tipoUsuario) {
        this.nomeEmpresaOuFaculdade = "NomeFaculdade." +random.nextInt(10)+""+random.nextInt(10)+""
        +random.nextInt(10)+""+random.nextInt(10);
    }
    else {
        this.nomeEmpresaOuFaculdade = "NomeEmpresa." +random.nextInt(10)+""+random.nextInt(10)+""
        +random.nextInt(10)+""+random.nextInt(10);
    }

    if (tipoUsuario)
    {
        this.descriçãoDaVaga = "DescriçãoDaVaga." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
        this.horarioDoTrabalho = "HorarioDoTrabalho." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
        this.cargaHoraria = "CargaHoraria." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
        this.tempoPrevistoDoContrato = "TempoPrevistoDoContrato." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
        this.local = "Local." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
        this.observacoesSobrAVaga = "ObservacoesSobrAVaga." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
        this.beneficios = "Beneficios." +random.nextInt(10)+""+random.nextInt(10)+""
                +random.nextInt(10)+""+random.nextInt(10);
    }
    else {
        this.descriçãoDaVaga = null;
        this.horarioDoTrabalho = null;
        this.cargaHoraria = null;
        this.cargaHoraria = null;
        this.tempoPrevistoDoContrato = null;
        this.local = null;
        this.observacoesSobrAVaga = null;
        this.beneficios = null;
    }


    // dados para a Rede Neural:
    this.vaga = numeroAleatorioEntre(0, 4);
    this.pretensaoSalarial = numeroAleatorioEntre(2, 4);


    this.tempoAteOTrabalho = numeroAleatorioEntre(2, 4);
    this.experiencia = numeroAleatorioEntre(2, 4);
    this.tempoNaUltimaEmpresa = numeroAleatorioEntre(2, 4);
    this.ocupacaoAtual = numeroAleatorioEntre(0, 2);
    this.grauEscolaridade = numeroAleatorioEntre(2, 4);
    this.cursoQueEstaEstudando = numeroAleatorioEntre(10, 48);
    this.semestreNaFaculdade = numeroAleatorioEntre(3, 7);

    this.tipoDeFaculdade = numeroAleatorioEntre(0, 3);

    this.sexo = numeroAleatorioEntre(0, 1);
    this.faixaEtaria = numeroAleatorioEntre(1, 4);
    this.nacionalidade = numeroAleatorioEntre(0, 1);
    this.estadoCivil = numeroAleatorioEntre(0, 2);
    this.numeroDeFilhos = numeroAleatorioEntre(0, 2);
    this.temCarroProrio = numeroAleatorioEntre(0, 1);
    this.tipoCarteiraMotorista = numeroAleatorioEntre(2, 4);

    if (apto) {this.c1 = numeroAleatorioEntre(0, 24);} else {this.c1 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c2 = numeroAleatorioEntre(0, 24);} else {this.c2 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c3 = numeroAleatorioEntre(0, 24);} else {this.c3 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c4 = numeroAleatorioEntre(0, 24);} else {this.c4 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c5 = numeroAleatorioEntre(0, 24);} else {this.c5 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c6 = numeroAleatorioEntre(0, 24);} else {this.c6 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c7 = numeroAleatorioEntre(0, 24);} else {this.c7 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c8 = numeroAleatorioEntre(0, 24);} else {this.c8 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c9 = numeroAleatorioEntre(0, 24);} else {this.c9 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c10 = numeroAleatorioEntre(0, 24);} else {this.c10 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c11 = numeroAleatorioEntre(0, 24);} else {this.c11 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c12 = numeroAleatorioEntre(0, 24);} else {this.c12 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c13= numeroAleatorioEntre(0, 24);} else {this.c13 = numeroAleatorioEntre(25, 50);}
    if (apto) {this.c14 = numeroAleatorioEntre(0, 24);} else {this.c14= numeroAleatorioEntre(25, 50);}
    if (apto) {this.c15 = numeroAleatorioEntre(0, 24);} else {this.c15 = numeroAleatorioEntre(25, 50);}





}


private static int numeroAleatorioEntre(int min, int max) {
    Random random= new Random();
    int n = min + random.nextInt(max);
    return n;
    }

//    private static double randomNumber(int min, int max) {
//        DecimalFormat df =  new DecimalFormat("#,#####");
//        double d = min + Math.random()*(max - min);
//        String s = df.format(d);
//        double x = Double.parseDouble(s);
//        return x;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNacimento() {
        return nacimento;
    }

    public void setNacimento(int nacimento) {
        this.nacimento = nacimento;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getNomeEmpresaOuFaculdade() {
        return nomeEmpresaOuFaculdade;
    }

    public void setNomeEmpresaOuFaculdade(String nomeEmpresaOuFaculdade) {
        this.nomeEmpresaOuFaculdade = nomeEmpresaOuFaculdade;
    }

    public String getDescriçãoDaVaga() {
        return descriçãoDaVaga;
    }

    public void setDescriçãoDaVaga(String descriçãoDaVaga) {
        this.descriçãoDaVaga = descriçãoDaVaga;
    }

    public String getHorarioDoTrabalho() {
        return horarioDoTrabalho;
    }

    public void setHorarioDoTrabalho(String horarioDoTrabalho) {
        this.horarioDoTrabalho = horarioDoTrabalho;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTempoPrevistoDoContrato() {
        return tempoPrevistoDoContrato;
    }

    public void setTempoPrevistoDoContrato(String tempoPrevistoDoContrato) {
        this.tempoPrevistoDoContrato = tempoPrevistoDoContrato;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacoesSobrAVaga() {
        return observacoesSobrAVaga;
    }

    public void setObservacoesSobrAVaga(String observacoesSobrAVaga) {
        this.observacoesSobrAVaga = observacoesSobrAVaga;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public int getVaga() {
        return vaga;
    }

    public void setVaga(int vaga) {
        this.vaga = vaga;
    }

    public int getPretensaoSalarial() {
        return pretensaoSalarial;
    }

    public void setPretensaoSalarial(int pretensaoSalarial) {
        this.pretensaoSalarial = pretensaoSalarial;
    }


    public int getTempoAteOTrabalho() {
        return tempoAteOTrabalho;
    }

    public void setTempoAteOTrabalho(int tempoAteOTrabalho) {
        this.tempoAteOTrabalho = tempoAteOTrabalho;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getTempoNaUltimaEmpresa() {
        return tempoNaUltimaEmpresa;
    }

    public void setTempoNaUltimaEmpresa(int tempoNaUltimaEmpresa) {
        this.tempoNaUltimaEmpresa = tempoNaUltimaEmpresa;
    }

    public int getOcupacaoAtual() {
        return ocupacaoAtual;
    }

    public void setOcupacaoAtual(int ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }

    public int getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(int grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public int getCursoQueEstaEstudando() {
        return cursoQueEstaEstudando;
    }

    public void setCursoQueEstaEstudando(int cursoQueEstaEstudando) {
        this.cursoQueEstaEstudando = cursoQueEstaEstudando;
    }

    public int getSemestreNaFaculdade() {
        return semestreNaFaculdade;
    }

    public void setSemestreNaFaculdade(int semestreNaFaculdade) {
        this.semestreNaFaculdade = semestreNaFaculdade;
    }

    public int getTipoDeFaculdade() {
        return tipoDeFaculdade;
    }

    public void setTipoDeFaculdade(int tipoDeFaculdade) {
        this.tipoDeFaculdade = tipoDeFaculdade;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public int getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(int nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getNumeroDeFilhos() {
        return numeroDeFilhos;
    }

    public void setNumeroDeFilhos(int numeroDeFilhos) {
        this.numeroDeFilhos = numeroDeFilhos;
    }

    public int getTemCarroProrio() {
        return temCarroProrio;
    }

    public void setTemCarroProrio(int temCarroProrio) {
        this.temCarroProrio = temCarroProrio;
    }

    public int getTipoCarteiraMotorista() {
        return tipoCarteiraMotorista;
    }

    public void setTipoCarteiraMotorista(int tipoCarteiraMotorista) {
        this.tipoCarteiraMotorista = tipoCarteiraMotorista;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getC3() {
        return c3;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    public int getC4() {
        return c4;
    }

    public void setC4(int c4) {
        this.c4 = c4;
    }

    public int getC5() {
        return c5;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    public int getC6() {
        return c6;
    }

    public void setC6(int c6) {
        this.c6 = c6;
    }

    public int getC7() {
        return c7;
    }

    public void setC7(int c7) {
        this.c7 = c7;
    }

    public int getC8() {
        return c8;
    }

    public void setC8(int c8) {
        this.c8 = c8;
    }

    public int getC9() {
        return c9;
    }

    public void setC9(int c9) {
        this.c9 = c9;
    }

    public int getC10() {
        return c10;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }

    public int getC11() {
        return c11;
    }

    public void setC11(int c11) {
        this.c11 = c11;
    }

    public int getC12() {
        return c12;
    }

    public void setC12(int c12) {
        this.c12 = c12;
    }

    public int getC13() {
        return c13;
    }

    public void setC13(int c13) {
        this.c13 = c13;
    }

    public int getC14() {
        return c14;
    }

    public void setC14(int c14) {
        this.c14 = c14;
    }

    public int getC15() {
        return c15;
    }

    public void setC15(int c15) {
        this.c15 = c15;
    }

    public int getC16() {
        return c16;
    }

    public void setC16(int c16) {
        this.c16 = c16;
    }

    public int getC17() {
        return c17;
    }

    public void setC17(int c17) {
        this.c17 = c17;
    }

    public int getC18() {
        return c18;
    }

    public void setC18(int c18) {
        this.c18 = c18;
    }

    public int getC19() {
        return c19;
    }

    public void setC19(int c19) {
        this.c19 = c19;
    }

    public int getC20() {
        return c20;
    }

    public void setC20(int c20) {
        this.c20 = c20;
    }
}
