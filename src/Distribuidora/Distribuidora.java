/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribuidora;

import distribuidoraDAO.ClienteDAO;
import distribuidoraDAO.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author Gabriel
 */
public class Distribuidora extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        abrirTela("Login.fxml", Login.class);
    }
    
    public static void abrirTela(String view, Class c){
        Parent parent = null;
        try {
            parent = FXMLLoader.load(c.getResource(view));
        } catch (IOException ex) {
            Logger.getLogger(Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        java.util.Date dataUtil = new java.util.Date();  
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime()); 
        System.out.println(dataUtil);
        System.out.println("'''''''''''''''''''''");
        System.out.println(dataSql);
        
        Cliente c1 = new Cliente();
        c1.setNome("Gabriel");
        c1.setCpf("11122233344");
        c1.setEndereco("rua tiete");
        c1.setNumero(711);
        c1.setCep("87020210");
        c1.setEmail("gabrieldiasmartinelli@gmail.com");
        c1.setTelefone("4430319203");
        c1.setCelular("44999571190");
        c1.setDataCadastro(dataSql);
        ClienteDAO cdao = new ClienteDAO();
        cdao.save(c1);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
