/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package Distribuidora;

import Distribuidora.ClienteController;
import Distribuidora.Distribuidora;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */

public class Main {
    
    @FXML Text nomeCliente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private JFXButton btBuscarCliente;

    @FXML
    public void initialize() {
    }
    
    @FXML
    private void cadastrarCliente(ActionEvent event) throws IOException {
        Distribuidora.abrirTela("/view/Cliente.fxml", ClienteController.class);
    }
    
    @FXML
    private void buscarCliente(ActionEvent event) throws IOException {
//        Distribuidora.abrirTela("/view/ListaClientes.fxml", ListaClienteController.class);
        FXMLLoader loader = new FXMLLoader(ListaClienteController.class.getResource("/view/ListaClientes.fxml"));  
        Stage stage = new Stage();
        stage.initOwner(btBuscarCliente.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));

        // showAndWait will block execution until the window closes...
        stage.showAndWait();

        ListaClienteController controller = loader.getController();
        nomeCliente.setText(controller.getNomeCliente());
    }

}
