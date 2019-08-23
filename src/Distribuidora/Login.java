/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribuidora;


import Distribuidora.Distribuidora;
import distribuidoraDAO.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import modelo.Usuario;

/**
 *
 * @author Gabriel
 */
public class Login implements Initializable {
    
    @FXML
    private TextField tfUsuario;
    
    @FXML
    private PasswordField pwfSenha;    
    
    @FXML
    private Button btEntrar;
    
    @FXML
    private void testeBotao(ActionEvent event) {
        System.out.println(tfUsuario.getText());
        System.out.println(pwfSenha.getText());
        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = new Usuario();
        
        try {
            System.out.println(udao.findName("ab").getNome());
        } catch (NullPointerException e) {
            System.out.println("Usuário não encontrado!");
        }



//        Distribuidora.loadScene("Main.fxml");
        
        Distribuidora d = new Distribuidora();
        ((Node) event.getSource()).getScene().getWindow().hide();// fechar tela atual
        d.abrirTela("Main.fxml", Main.class);
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
