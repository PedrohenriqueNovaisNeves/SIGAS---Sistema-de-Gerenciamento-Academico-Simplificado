package validations;
import pessoas.Aluno;
import pessoas.Professor;
import acoesBD.AcoesBD;

public class Validations {
    
    public Validations(){
    }
    
    public boolean validationsOfTestNotes(double note){
        
        if((note > 30)||(note < 0)){
            return true;
        }
        return false;
    }
    
    public boolean validationOfWorkGrade(double note){
        
        if((note < 0)||(note > 40)){
            return true;
        }
        
        return false;
    }
    
    public boolean validationRegistrationAluno(String ra, String raInserted){
        
        if(!raInserted.equals(ra)){
            return true;
        }
        
        return false;
    }
    
    public boolean validationData(String cpf, String cpfInserted){
        
        if(cpfInserted.equals(cpf)){
            return true;
        }
        return false;
    }
    
    public boolean validationCharacters(String characters){
        
        char[] convertStringtoChar = characters.toCharArray();
        int numberOfCharacters = convertStringtoChar.length;
        
        if(numberOfCharacters != 11){
            return true;
        }
        
        return false;
    }
    
    public boolean validationRgData(String rg){
        
        char[] convertStringtoChar = rg.toCharArray();
        int numberOfCharacters = convertStringtoChar.length;
        
        if(numberOfCharacters != 9){
            return true;
        }
        
        return false;
    }
    
    public boolean validationRaData(String ra){
        
        char[] convertStringtoChar = ra.toCharArray();
        int numberOfCharacters = convertStringtoChar.length;
        
        if(numberOfCharacters != 12){
            return true;
        }
        
        return false;
    }           
    
    public boolean validationRegistrationData(String registration){
        
        char[] convertStringtoChar = registration.toCharArray();
        int numberOfCharacters = convertStringtoChar.length;
        
        if(numberOfCharacters != 10){
            return true;
        }
        
        return false;
    }
    
    public boolean dataInserted(String data){
        
        if(data.equals("")){
            return true;
        }
        
        return false;
    }   
}
