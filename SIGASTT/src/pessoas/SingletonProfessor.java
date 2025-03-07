
package pessoas;

public class SingletonProfessor {
    
    private static SingletonProfessor instancia;
    
    private Professor professor;
    
    private SingletonProfessor(){}
    
    public static SingletonProfessor getInstance(){
        
        if(instancia == null){
            instancia = new SingletonProfessor();
        }
        
        return instancia;
    }
    
    public static void reset(){
        instancia = null;
    }
    
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public Professor getProfessor(){
        return professor;
    }
    
    public String getNameProfessor(){
        return (professor != null) ? professor.getNome() : "Nome nao localizado!";
    }
    
    public String getCpfProfessor(){
        return (professor != null) ? professor.getCPF() : "Cpf nao localizado";
    }
    
    public String getMatriculaProfesor(){
        return (professor != null) ? professor.getMatricula() : "Matricula nao localizada!!";
    }
    
    
}
