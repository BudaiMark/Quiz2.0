package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LaunchController {
    private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black;";

    @FXML
    private TextField playerTextfield;



    @FXML
    private Label errorLabel;

    @FXML
    private Button startButton;




    public void startAction(ActionEvent actionEvent) throws IOException {
        if (playerTextfield.getText().isEmpty()) {
            errorLabel.setText("Játékos neve üres");
        }


        if (!playerTextfield.getText().isEmpty()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }
    @FXML
    public void initialize(){
        startButton.setStyle(STANDARD_BUTTON);


    }

}
