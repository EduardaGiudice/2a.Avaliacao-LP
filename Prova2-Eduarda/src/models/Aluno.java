package models;


public class Aluno {

    private int idal;
    private String cpf;
    private String nome;
    private String dataNascimento;
    private float peso;
    private float altura;

    public int getIdal() {
        return idal;
    }

    public void setIdal(int idal) {
        this.idal = idal;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void mostrarAltura() {
        System.out.println("Altura do aluno " + altura);
    }
}
