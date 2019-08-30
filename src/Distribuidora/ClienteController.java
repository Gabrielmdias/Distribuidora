/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribuidora;

import com.jfoenix.controls.JFXTextField;
import distribuidoraDAO.ClienteDAO;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelo.Cliente;
import resources.maskJFXTextField;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ClienteController implements Initializable {

    @FXML private JFXTextField tfid;
    @FXML private JFXTextField tfNome;
    @FXML private JFXTextField tfCpf;
    @FXML private JFXTextField tfEndereco;
    @FXML private JFXTextField tfNumero;
    @FXML private JFXTextField tfCep;
    @FXML private JFXTextField tfEmail;
    @FXML private JFXTextField tfTelefone;
    @FXML private JFXTextField tfCelular;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maskJFXTextField.mascaraCPF(tfCpf);
        maskJFXTextField.mascaraEmail(tfEmail);
        maskJFXTextField.mascaraTelefone(tfTelefone);
        maskJFXTextField.mascaraTelefone(tfCelular);
        maskJFXTextField.mascaraNumeroInteiro(tfNumero);
        maskJFXTextField.mascaraCEP(tfCep);
    }    
    
    @FXML
    public boolean validarCampos(){
        if(tfNome.getText().length()<5){
            return false;
        }
        //terminar depois
        return true;
    }
    
    
    @FXML
    public void salvar(ActionEvent event){
        
//        if(validarCampos())
        java.util.Date dataUtil = new java.util.Date();  
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime()); 
        
        ClienteDAO cdao = new  ClienteDAO();
        Cliente c = new Cliente();
        c.setNome(tfNome.getText());
        c.setCpf(tfCpf.getText());
        c.setEndereco(tfEndereco.getText());
        c.setNumero(Integer.parseInt(tfNumero.getText()));
        c.setCep(tfCep.getText());
        c.setEmail(tfEmail.getText());
        c.setTelefone(tfTelefone.getText());
        c.setCelular(tfCelular.getText());
        c.setDataCadastro(dataSql);
        cdao.save(c);
    }

    public JFXTextField getTfid() {
        return tfid;
    }

    public void setTfid(JFXTextField tfid) {
        this.tfid = tfid;
    }

    public JFXTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JFXTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JFXTextField getTfCpf() {
        return tfCpf;
    }

    public void setTfCpf(JFXTextField tfCpf) {
        this.tfCpf = tfCpf;
    }

    public JFXTextField getTfEndereco() {
        return tfEndereco;
    }

    public void setTfEndereco(JFXTextField tfEndereco) {
        this.tfEndereco = tfEndereco;
    }

    public JFXTextField getTfNumero() {
        return tfNumero;
    }

    public void setTfNumero(JFXTextField tfNumero) {
        this.tfNumero = tfNumero;
    }

    public JFXTextField getTfCep() {
        return tfCep;
    }

    public void setTfCep(JFXTextField tfCep) {
        this.tfCep = tfCep;
    }

    public JFXTextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(JFXTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    public JFXTextField getTfTelefone() {
        return tfTelefone;
    }

    public void setTfTelefone(JFXTextField tfTelefone) {
        this.tfTelefone = tfTelefone;
    }

    public JFXTextField getTfCelular() {
        return tfCelular;
    }

    public void setTfCelular(JFXTextField tfCelular) {
        this.tfCelular = tfCelular;
    }
    
}
