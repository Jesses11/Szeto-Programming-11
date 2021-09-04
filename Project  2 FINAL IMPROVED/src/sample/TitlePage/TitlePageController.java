package sample.TitlePage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.EndPage.EndPageController;
import sample.Game.GamePageController;

//controls TitlePage.fxml
public class TitlePageController {

    public TextField txtGetPlayerName;

    //Requires: ActionEvent event
    //Modifies: this, gamePage and window
    //Effects: gamePageParent is created from GamePage.fxml, gamePageScene is created and window
    public void changeToGamePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Game/GamePage.fxml"));
        Parent gamePageParent = (Parent)loader.load();
        GamePageController controller = (GamePageController)loader.getController();
        controller.displayPlayerName.setText(txtGetPlayerName.getText());
        Scene gamePageScene = new Scene(gamePageParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(gamePageScene);
        window.show();
        controller.startPlay();
    }

    //Requires: ActionEvent event (call this to terminate).
    //Modifies: this, window
    //Effects: Terminates the application.
    public void closeProgram(ActionEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
