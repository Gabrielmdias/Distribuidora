package Distribuidora;

import distribuidoraDAO.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Cliente;
import resources.AlertMaker;
import resources.Util;

public class ListaClienteController implements Initializable {

    ObservableList<Cliente> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Cliente> tableView;
    @FXML
    private TableColumn<Cliente, Long> idCol;
    @FXML
    private TableColumn<Cliente, String> nomeCol;
    @FXML
    private TableColumn<Cliente, String> celularCol;
    @FXML
    private TableColumn<Cliente, String> emailCol;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    
    private String nomeCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
    }

    private void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        celularCol.setCellValueFactory(new PropertyValueFactory<>("celular"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private Stage getStage() {
        return (Stage) tableView.getScene().getWindow();
    }

    private void loadData() {
        list.clear();

        ClienteDAO cdao = new ClienteDAO();
        List<Cliente> listClientes = new ArrayList<Cliente>();
        try {
            listClientes = cdao.findAll();
            for(Cliente c : listClientes) {
                Long id = c.getId();
                String nome = c.getNome();
                String celular = c.getCelular();
                String email = c.getEmail();

                list.add(new Cliente(id, nome, celular, email));

            }
        } catch (NullPointerException e) {
            Logger.getLogger(ListaClienteController.class.getName()).log(Level.SEVERE, null, e);
        }

        tableView.setItems(list);
    }

    @FXML
    private void handleMemberDelete(ActionEvent event) throws IOException {
        //Fetch the selected row
        Cliente selecionado = tableView.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            AlertMaker.showErrorMessage("Cliente não selecionado", "Por favor, selecione um cliente.");
            return;
        }
        ClienteDAO cdao = new ClienteDAO();
        Cliente c = cdao.find(Cliente.class, selecionado.getId());
        if (c != null) {
            nomeCliente = c.getNome();
        }else{
            AlertMaker.showErrorMessage("Cliente não encontrado", "O cliente não foi encontrado no banco.");
        }
    }
    
    @FXML
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Cliente selecionado = tableView.getSelectionModel().getSelectedItem();
            if (selecionado == null) {
                AlertMaker.showErrorMessage("Cliente não selecionado", "Por favor, selecione um cliente.");
                return;
            }
            ClienteDAO cdao = new ClienteDAO();
            Cliente c = cdao.find(Cliente.class, selecionado.getId());
            if (c != null) {
                nomeCliente = c.getNome();
            }else{
                AlertMaker.showErrorMessage("Cliente não encontrado", "O cliente não foi encontrado no banco.");
            }
            ((Node) event.getSource()).getScene().getWindow().hide();// fechar tela atual
        }
    }
    
    

    @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();
    }

//    @FXML
//    private void handleMemberEdit(ActionEvent event) {
//        //Fetch the selected row
//        Member selectedForEdit = tableView.getSelectionModel().getSelectedItem();
//        if (selectedForEdit == null) {
//            AlertMaker.showErrorMessage("No member selected", "Please select a member for edit.");
//            return;
//        }
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/library/assistant/ui/addmember/member_add.fxml"));
//            Parent parent = loader.load();
//
//            MemberAddController controller = (MemberAddController) loader.getController();
//            controller.infalteUI(selectedForEdit);
//
//            Stage stage = new Stage(StageStyle.DECORATED);
//            stage.setTitle("Edit Member");
//            stage.setScene(new Scene(parent));
//            stage.show();
//            LibraryAssistantUtil.setStageIcon(stage);
//
//            stage.setOnHiding((e) -> {
//                handleRefresh(new ActionEvent());
//            });
//
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    @FXML
//    private void exportAsPDF(ActionEvent event) {
//        List<List> printData = new ArrayList<>();
//        String[] headers = {"   Name    ", "ID", "Mobile", "    Email   "};
//        printData.add(Arrays.asList(headers));
//        for (Member member : list) {
//            List<String> row = new ArrayList<>();
//            row.add(member.getName());
//            row.add(member.getId());
//            row.add(member.getMobile());
//            row.add(member.getEmail());
//            printData.add(row);
//        }
//        LibraryAssistantUtil.initPDFExprot(rootPane, contentPane, getStage(), printData);
//    }

    @FXML
    private void closeStage(ActionEvent event) {
        getStage().close();
    }

}
