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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import modelo.Usuario;
import resources.AlertMaker;

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
    private void entrarMouse(ActionEvent event) {
        UsuarioDAO udao = new UsuarioDAO();

        try {
            Usuario u = udao.findName(tfUsuario.getText().toUpperCase());
            if (u.getSenha().equals(pwfSenha.getText())) {
                ((Node) event.getSource()).getScene().getWindow().hide();// fechar tela atual
                Distribuidora.abrirTela("/view/Main.fxml", Main.class);
            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText("Senha");
//                alert.setContentText("Senha inválida!");
//                alert.show();
                AlertMaker.showErrorMessage("Senha", "Senha inválida!");
            }
        } catch (NullPointerException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText("Usuário");
//            alert.setContentText("Usuário não encontrado!");
//            alert.show();
            AlertMaker.showErrorMessage("Usuário", "Usuário não encontrado!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
