package sigas;
import conexoes.ConexaoMySQL;
import pessoas.*;
import tela.*;
import java.sql.SQLException;
import acoesBD.*;
import validations.*;

/*
Aqui no main a implementacao das classes esta bem autoexplicativa, bem facil de entender.
*/

public class SIGAS {

public static void main(String[] args) throws SQLException {
        Professor pro1 = new Professor();
        Aluno aluno1 = new Aluno();
        ConexaoMySQL teste = new ConexaoMySQL();
        AcoesBD acoesBd = new AcoesBD();
        Validations validation = new Validations();
        
        teste.getConexaoMySQL();
        System.out.println(teste.status);
        
        Tela tl = new Tela();
        tl.setVisible(true);
        
    }
}