/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribuidora;

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

/**
 *
 * @author Gabriel
 */
public class Distribuidora extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        abrirTela("Login.fxml", Login.class);
    }
    
    public void abrirTela(String view, Class c){
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
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
