package acoesBD;

import conexoes.ConexaoMySQL;
import java.sql.*;
import notas.*;
import pessoas.*;

public class AcoesBD {

    ConexaoMySQL connection = new ConexaoMySQL();
    Notas notas = new Notas();

    private int idUser;
    
    private int idAluno;
    
    private String cpfUser;
    
    private String raAluno;

    public void InsertUser(String name, String cpf, String rg) {
        try (PreparedStatement Insert = connection.getConexaoMySQL().prepareStatement("insert into tb_Usuario (username, userRg, userCpf) values (?, ?, ?)")) {
            Insert.setString(1, name);
            Insert.setString(2, rg);
            Insert.setString(3, cpf);

            int insert = Insert.executeUpdate();

            if (insert != 1) {
                System.out.println("registration not completed, check that all data is correct");
            }

            System.out.println("User successfully registered");

            Insert.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            System.out.println("error when registering User");
            e.printStackTrace();
        }
    }
    
    public void selectCpf(String cpf){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select userCpf from tb_Usuario where userCpf = ?")){
            select.setString(1, cpf);
            
            try(ResultSet resultSelect = select.executeQuery()){
                if(resultSelect.next()){
                    String cpfUser = resultSelect.getString("userCpf");
                    
                    this.cpfUser = cpfUser;
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public String getCpfUser(){
        return cpfUser;
    }
    
    public void SelectUser(int id) {
        try (PreparedStatement Select = connection.getConexaoMySQL().prepareStatement("select * from tb_Usuario where idUser = ?")) {
            Select.setInt(1, id);

            try (ResultSet resultSelect = Select.executeQuery()) {

                if (resultSelect.next()) {
                    String nameUser = resultSelect.getString("username");
                    String cpf = resultSelect.getNString("userCpf");
                    String rg = resultSelect.getNString("userRg");

                    System.out.println(nameUser);
                    System.out.println(cpf);
                    System.out.println(rg);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            Select.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setIdUser(String nameUser) {
        try (PreparedStatement selectId = connection.getConexaoMySQL().prepareStatement("select idUser from tb_Usuario where username = ?")) {
            selectId.setString(1, nameUser);

            try (ResultSet resultSelect = selectId.executeQuery()) {

                if (resultSelect.next()) {
                    int id = resultSelect.getInt("idUser");

                    this.idUser = id;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            selectId.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIdUser() {
        return idUser;
    }

    public void UpdateUser(String name, String cpf, String rg, int idUser) {
        try (PreparedStatement Update = connection.getConexaoMySQL().prepareStatement("update tb_Usuario set username = ?, userRg = ?, userCpf = ? where idUser = ?")) {
            Update.setString(1, name);
            Update.setString(2, rg);
            Update.setString(3, cpf);
            Update.setInt(4, idUser);

            int updateUser = Update.executeUpdate();

            if (updateUser != 1) {
                System.out.println("Update not completed");
            }

            System.out.println("Update complete successfully");

            Update.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int idUser) {
        try (PreparedStatement Delete = connection.getConexaoMySQL().prepareStatement("delete from tb_Usuario where idUser = ?")) {
            Delete.setInt(1, idUser);

            int deleteUser = Delete.executeUpdate();

            if (deleteUser != 1) {
                System.out.println("Delete not completed");
            }

            System.out.println("Delete completed successfully");

            Delete.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProfessor(String matricula, int id) {
        try (PreparedStatement Insert = connection.getConexaoMySQL().prepareStatement("insert into tb_professor (matricula, idUser) values (?, ?)")) {
            Insert.setString(1, matricula);
            Insert.setInt(2, id);

            int insertPro = Insert.executeUpdate();

            if (insertPro != 1) {
                System.out.println("Error when registering teacher");
            }

            System.out.println("Ok!");

            Insert.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectProfessor(int id) {
        try (PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select * from tb_professor where idUser = ?")) {
            select.setInt(1, id);

            try (ResultSet resultSelect = select.executeQuery()) {
                if (resultSelect.next()) {
                    String matricula = resultSelect.getNString("matricula");

                    System.out.println(matricula);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            select.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProfessor(String matricula, int id) {
        try (PreparedStatement update = connection.getConexaoMySQL().prepareStatement("update tb_professor set matricula = ? where idUser = ?")) {
            update.setString(1, matricula);
            update.setInt(2, id);

            int updateProfessor = update.executeUpdate();

            if (updateProfessor != 1) {
                System.out.println("update teacher not completed");
            }

            System.out.println("Update completed successfully");

            update.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProfessor(int id) {
        try (PreparedStatement delete = connection.getConexaoMySQL().prepareStatement("delete from tb_professor where idUser = ?")) {
            delete.setInt(1, id);

            int deletePro = delete.executeUpdate();

            if (deletePro != 1) {
                System.out.println("Error, delete not completed");
            }

            System.out.println("Delete completed successfully");

            delete.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAluno(String ra, int id) {
        try (PreparedStatement insert = connection.getConexaoMySQL().prepareStatement("insert into tb_Aluno (registroAcademico, idUser) values (?, ?)")) {
            insert.setString(1, ra);
            insert.setInt(2, id);

            int insertAluno = insert.executeUpdate();

            if (insertAluno != 1) {
                System.out.println("Error when registering student");
            }

            System.out.println("Student registred successfully");

            insert.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAluno(int id) {
        try (PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select * from tb_Usuario where idUser = ?")) {
            select.setInt(1, id);

            try (ResultSet resultSelect = select.executeQuery()) {

                if (resultSelect.next()) {
                    Aluno aluno = new Aluno();
                    
                    aluno.setNome(resultSelect.getNString("username"));
                    aluno.setCPF(resultSelect.getString("userCpf"));
                    aluno.setRG(resultSelect.getString("userRg"));
                    
                    SingletonAluno.getInstance().setAluno(aluno);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            select.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void selectIdUserWithIdAluno(int idAluno){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select idUser from tb_Aluno where idAluno = ?")){
            select.setInt(1, idAluno);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    int id = resultSelect.getInt("idUser");
                    
                    this.idUser = id;
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            select.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void selectIdAlunoWithIdUser(int idUser){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select idAluno from tb_Aluno where idUser = ?")){
            select.setInt(1, idUser);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    
                    this.idAluno = resultSelect.getInt("idAluno");
                    
                }
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void selectRaAluno(int idAluno){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select registroAcademico from tb_Aluno where idAluno = ?")){
            select.setInt(1, idAluno);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    
                    SingletonAluno.getInstance().setRaAluno(resultSelect.getString("registroAcademico"));
                    
                }
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void selectAlunoWithRa(String ra){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select idAluno from tb_Aluno where registroAcademico = ?")){
            select.setString(1, ra);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    int idAluno = resultSelect.getInt("idAluno");
                    
                    this.idAluno = idAluno;
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            
            select.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void selectValidationAluno(String ra){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select registroAcademico from tb_Aluno where registroAcademico = ?")){
            select.setString(1, ra);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    
                    this.raAluno = resultSelect.getString("registroAcademico");
                    
                }
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            select.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public String getRaAluno(){
        return raAluno;
    }

    public void updateAluno(String ra, int id) {
        try (PreparedStatement update = connection.getConexaoMySQL().prepareStatement("update tb_Aluno set registroAcademico = ? where idUser = ?")) {
            update.setString(1, ra);
            update.setInt(2, id);

            int updateAluno = update.executeUpdate();

            if (updateAluno != 1) {
                System.out.println("Error when updating register to the student");
            }

            System.out.println("Update completed successfully");

            update.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAluno(int id) {
        try (PreparedStatement delete = connection.getConexaoMySQL().prepareStatement("delete from tb_Aluno where idUser = ?")) {
            delete.setInt(1, id);

            int deleteAluno = delete.executeUpdate();

            if (deleteAluno != 1) {
                System.out.println("Error when delete");
            }

            System.out.println("Delete completed successfully");

            delete.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setIdAluno(int idUser){
        try(PreparedStatement set = connection.getConexaoMySQL().prepareStatement("select idAluno from tb_Aluno where idUser = ?")){
            set.setInt(1, idUser);
            
            try(ResultSet resultSet = set.executeQuery()){
                if(resultSet.next()){
                    int idAluno = resultSet.getInt("idAluno");
                    
                    this.idAluno = idAluno;
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public int getIdAluno(){
        return idAluno;
    }
    
    public void insertNotas(double a1, double a2, double a3, int idAluno) {
        try (PreparedStatement insert = connection.getConexaoMySQL().prepareStatement("insert into tb_notas (a1, a2, a3, idAluno) values (?, ?, ?, ?)")) {
            insert.setDouble(1, a1);
            insert.setDouble(2, a2);
            insert.setDouble(3, a3);
            insert.setInt(4, idAluno);
            
            int insertNotas = insert.executeUpdate();
            
            if(insertNotas != 1){
                System.out.println("Error when registering notes");
            }
            
            System.out.println("Notes registered whit successfully");
            
            insert.close();
            connection.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertNotaFinal(double nf, int idAluno){
        try(PreparedStatement update = connection.getConexaoMySQL().prepareStatement("update tb_notas set notaFinal = ? where idAluno = ?")){
            update.setDouble(1, nf);
            update.setInt(2, idAluno);
            
            int updateNf = update.executeUpdate();
            
            if(updateNf == 0){
                System.out.println("Error when registering final grade");
            }
            
            System.out.println("Final grade registered whit successfully");
            
            update.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateNotas(double a1, double a2, double a3, int idAluno){
        try(PreparedStatement update = connection.getConexaoMySQL().prepareStatement("update tb_notas set a1 = ?, a2 = ?, a3 = ? where idAluno = ?")){
            update.setDouble(1, a1);
            update.setDouble(2, a2);
            update.setDouble(3, a3);
            update.setInt(4, idUser);
            
            int updateNotas = update.executeUpdate();
            
            if(updateNotas == 0){
                System.out.println("Error updating notes");
            }
            
            System.out.println("Notes updated successfully");
            
            update.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateNotafinal(double notaFinal, int idAluno){
        try(PreparedStatement update = connection.getConexaoMySQL().prepareStatement("update tb_notas set notaFinal = ? where idAluno = ?")){
            update.setDouble(1, notaFinal);
            update.setInt(2, idUser);
            
            int updateNotafinal = update.executeUpdate();
            
            if(updateNotafinal == 0){
                System.out.println("Error updating final grade");
            }
            
            System.out.println("Successfully updated final grade");
            
            update.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void selectNotas(int idAluno){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select a1, a2, a3 from tb_notas where idAluno = ?")){
            select.setInt(1, idAluno);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    double notaA1 = resultSelect.getDouble("a1");
                    double notaA2 = resultSelect.getDouble("a2");
                    double notaA3 = resultSelect.getDouble("a3");
                    
                    System.out.println(notaA1);
                    System.out.println(notaA2);
                    System.out.println(notaA3);
                    
                }
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            select.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void selectNotaFinal(int idAluno){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select notaFinal from tb_notas where idAluno = ?")){
            select.setInt(1, idAluno);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    double notaFinal = resultSelect.getDouble("notaFinal");
                    
                    System.out.println(notaFinal);
                }
            }
            
            select.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        } 
   }
    
    public void selectAllNotes(int idAluno){
        try(PreparedStatement select = connection.getConexaoMySQL().prepareStatement("select a1, a2, a3, notaFinal from tb_notas where idAluno = ?")){
            select.setInt(1, idAluno);
            
            try(ResultSet resultSelect = select.executeQuery()){
                
                if(resultSelect.next()){
                    Notas notas = new Notas();
                    
                    notas.setNotaA1(resultSelect.getInt("a1"));
                    notas.setNotaA2(resultSelect.getInt("a2"));
                    notas.setNotaA3(resultSelect.getInt("a3"));
                    notas.setNotaFinal(resultSelect.getInt("notaFinal"));
                    
                    SingletonNotas.getInstance().setNotas(notas);
                    
                }
                
            }catch(SQLException e){
                e.printStackTrace();
            }
                    
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteA1(int idAluno){
        try(PreparedStatement delete = connection.getConexaoMySQL().prepareStatement("delete a1 from tb_notas where idAluno = ?")){
            delete.setInt(1, idAluno);
            
            int deleteNota = delete.executeUpdate();
            
            if(deleteNota == 0){
                
                System.out.println("Error when deleting A1");
                
            }
            
            System.out.println("A1 delete successfully");
            
            delete.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteA2(int idAluno){
        try(PreparedStatement delete = connection.getConexaoMySQL().prepareStatement("delete a2 from tb_notas where idAluno = ?")){
            delete.setInt(1, idAluno);
            
            int deleteNota = delete.executeUpdate();
            
            if(deleteNota == 0){
                
                System.out.println("Error when deleting A2");
                
            }
            
            System.out.println("A2 delete successfully");
            
            delete.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteA3(int idAluno){
        try(PreparedStatement delete = connection.getConexaoMySQL().prepareStatement("delete a3 from tb_notas where idAluno = ?")){
            delete.setInt(1, idAluno);
            
            int deleteNota = delete.executeUpdate();
            
            if(deleteNota == 0){
                
                System.out.println("Error when deleting A3");
                
            }
            
            System.out.println("A3 delete successfully");
            
            delete.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteNotaFinal(int idAluno){
        try(PreparedStatement delete = connection.getConexaoMySQL().prepareStatement("delete notaFinal from tb_notas where idAluno = ?")){
            delete.setInt(1, idAluno);
            
            int deleteNota = delete.executeUpdate();
            
            if(deleteNota == 0){
                
                System.out.println("Error when deleting final grade");
                
            }
            
            System.out.println("final grade delete successfully");
            
            delete.close();
            connection.FecharConexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
