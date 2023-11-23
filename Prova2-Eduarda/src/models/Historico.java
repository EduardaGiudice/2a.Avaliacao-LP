package models;

public class Historico {

    private int idhist;
    private String dataHist;
    private float peso;
    private Aluno aluno;

    public int getIdhist() {
        return idhist;
    }

    public void setIdhist(int idhist) {
        this.idhist = idhist;
    }

    public String getDataHist() {
        return dataHist;
    }

    public void setDataHist(String dataHist) {
        this.dataHist = dataHist;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    }