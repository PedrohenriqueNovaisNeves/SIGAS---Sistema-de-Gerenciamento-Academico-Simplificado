package pessoas;

import java.util.UUID;

/*
Temos aqui a classe Aluno, que tambem e uma extensao da classe Pessoas, porem ela tera um atributo que ira armazenar o RA, e outro que ira armazenar
a nota final.
 */
public class Aluno extends Usuario {
    private String RA;
    private int A1;
    private int A2;
    private int A3;
    private int NF;

    /*
    Assim como nas outras classes tambem temos um contrutor vazio.
     */
    public Aluno() {
        super();
        this.RA = null;
        this.NF = 0;
        this.A1 = 0;
        this.A2 = 0;
        this.A3 = 0;
    }

    /*
    O RA do aluno segue a mesma logica da matricula do professor, caso o atributo do objeto esteja vazio ele ira armazenar o RA inserido pelo usuario
     */
    public void setRA(String ra) {
            this.RA = ra;
    }

    public String getRA() {
        return this.RA;
    }
    
    /*
    O metodo setNF tambem segue a mesma logica dos outros metodos de setar.
     */
    public void setNF(int nf){
            this.NF = nf;
    }
    
    public int getNF() {
        return this.NF;
    }

    public void setA1(int a1){
            this.A1 = a1;
    }

    public void setA2(int a2){
            this.A2 = a2;
    }

    public void setA3(int a3){
            this.A3 = a3;
    }

    public int getA1(){
        return A1;
    }

    public int getA2(){
        return A2;
    }

    public int getA3(){
        return A3;
    }
}
