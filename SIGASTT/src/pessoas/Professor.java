package pessoas;

/*
Como o proprio nome da classe diz, aqui teremos o Professor, ele sera uma extensao da classe Pessoas, contendo nome e CPF, porem ele tera
sua matricula.
 */

public class Professor extends Usuario {

    private String matricula;

    /*
    Assim como na classe pessoas temos aqui tambem um contrutor vazio, para podermos implementar o objeto Professor no main, sem a obrigatoriedade de
    passar algum parametros.
     */
    public Professor(){
        super();
        this.matricula = null;
    }

    /*
    Assim como no nome e no CPF, temos tambem um setMatricula, que testa se a matricula do objeto criado esta nula ou nao.
    Caso esteja nula(vazia) ele ira armazenar a matricula informada pelo usuario no atributo do objeto criado.
     */
    public void setMatricula(String matricula){
            this.matricula = matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }
}
