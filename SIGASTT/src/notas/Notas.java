package notas;


public class Notas {
    
    private double notaA1;
    private double notaA2;
    private double notaA3;
    private double notaFinal;
    
    public Notas(){}
    
    public void setNotaA1(double nota){
        this.notaA1 = nota;
    }
    
    public void setNotaA2(double nota){
        this.notaA2 = nota;
    }
    
    public void setNotaA3(double nota){
        this.notaA3 = nota;
    }
    
    public void setNotaFinal(double nota){
        this.notaFinal = nota;
    }
    
    public double getNotaA1(){
        return notaA1;
    }
    
    public double getNotaA2(){
        return notaA2;
    }
    
    public double getNotaA3(){
        return notaA3;
    }
    
    public double getNotaFinal(){
        return notaFinal;
    }
    
    
    
    public boolean verificaNotas(){
        if((this.notaA1 != 0)&&(this.notaA2 != 0)&&(this.notaA3 != 0)){
        return true;
    }else{
            return false;
        }
    }
    
    public void setFinalNote(double A1, double A2, double A3){
        double finalNote = A1 + A2 + A3;
        int finalNoteInt = (int)finalNote;
        
        setNotaFinal(finalNoteInt);
    }
    
    public boolean getResultAprovado(double notaFinal){
        
        if(notaFinal >= 70){
            return true;
        }
        
        return false;
    }
    
    public boolean getResultRecuperacao(double notaFinal){
        
        if((notaFinal > 50) && (notaFinal < 70)){
            return true;
        }
        
        return false;
    }
    
    public boolean getResultNaoCadastradas(double notaFinal){
        
        if(notaFinal <= 0){
            return true;
        }
        
        return false;
    }
}
