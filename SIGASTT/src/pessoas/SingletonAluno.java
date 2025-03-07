
package pessoas;


public class SingletonAluno {
    
    private static SingletonAluno instancia;
    private Aluno aluno;
    
    private SingletonAluno(){}
    
    public static SingletonAluno getInstance(){
        if(instancia == null){
            instancia = new SingletonAluno();
        }
        
        return instancia;
    }
    
    public Aluno getAluno(){
        return aluno;
    }
    
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public String getNameAluno(){
        return (aluno != null) ? aluno.getNome() : "Nome nao localizado";
    }
    
    public String getCpfAluno(){
        return (aluno != null) ? aluno.getCPF() : "Cpf nao localizado";
    }
    
    public String getRaAluno(){
        return (aluno != null) ? aluno.getRA() : "Ra nao localizado"; 
    }
    
    public static void reset(){
        instancia = null;
    }
    
    public void setRaAluno(String ra){
        this.aluno.setRA(ra);
    }
    
}
