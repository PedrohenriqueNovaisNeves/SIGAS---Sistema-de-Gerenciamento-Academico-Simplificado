
package notas;


public class SingletonNotas {
    
    private static SingletonNotas instancia;
    private Notas notas;
    
    private SingletonNotas(){
    }
    
    public static SingletonNotas getInstance(){
        
        if(instancia == null){
            instancia = new SingletonNotas();
        }
        
        return instancia;
    }
    
    public Notas getNotas(){
        return notas;
    }
    
    public void setNotas(Notas notas){
        this.notas = notas;
    }
    
    public double getNotaA1(){
        return (notas != null) ? notas.getNotaA1() : 0;
    }
    
    public double getNotaA2(){
        return (notas != null) ? notas.getNotaA2() : 0;
    }
    
    public double getNotaA3(){
        return (notas != null) ? notas.getNotaA3() : 0;
    }
    
    public double getNotaFinal(){
        return (notas != null) ? notas.getNotaFinal() : 0;
    }
    
    public static void reset(){
        instancia = null;
    }
    
    
}
