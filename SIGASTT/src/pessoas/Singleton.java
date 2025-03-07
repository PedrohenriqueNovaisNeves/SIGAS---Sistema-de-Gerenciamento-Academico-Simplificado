package pessoas;

public class Singleton {

    private static Singleton instancia;
    private Usuario usuario;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {

        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public String getCpfUsuario(){
        
        return (usuario != null) ? usuario.getCPF() : "CPF nao localizado";
        
    }
    
    public String getNomeUsuario(){
        
        return (usuario != null) ? usuario.getNome() : "Nome nao localizado";
        
    }
    
    public static void reset(){
        instancia = null;
    }
    
    
}
