/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package Distribuidora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */

public class Main {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label lbText;

    @FXML
    public void initialize() {
    }
    
    @FXML
    private void testeVenda(ActionEvent event) {
        lbText.setText("Gabriel 2");
    }
    
    
}
