package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import model.Database;
import model.User;

import java.io.IOException;
import java.util.List;

@Slf4j
public class ScoreController {
    private static final String STANDARD = "-fx-background-color: transparent; -fx-border-color: black;";

    @FXML
    private Button quitButton;

    @FXML
    private TableView<User> lastgame;
    @FXML
    private TableView<User> topgame;

    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, Integer> score;
    @FXML
    private TableColumn<User, Integer> topid;
    @FXML
    private TableColumn<User, String> topusername;
    @FXML
    private TableColumn<User, Integer> topscore;




    @FXML
    public void quitGame(ActionEvent actionEvent) throws IOException{

        Platform.exit();

    }

    public void writeStandardData(){
        List<User>userlist = Database.getUsers();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        ObservableList<User> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(userlist);

        lastgame.setItems(observableResult);

    }

    public void writeTopTenData(){
        List<User>userlist = Database.getTopTen();

        topid.setCellValueFactory(new PropertyValueFactory<>("id"));
        topusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        topscore.setCellValueFactory(new PropertyValueFactory<>("score"));
        ObservableList<User> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(userlist);

        topgame.setItems(observableResult);

    }

    @FXML
    public void initialize(){
        quitButton.setStyle(STANDARD);
        writeStandardData();
        writeTopTenData();





    }

}
