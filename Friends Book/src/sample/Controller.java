package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public ListView<Friend> friendList = new ListView<>();
    public Button createFriend;
    public Label lblPhoneNumber;
    public Label lblAge;
    public Label lblAddress;
    public Label lblEmail;
    public Label lblName;
    public Button btnRemoveFriend;
    public TextField getFirstName;
    public TextField getLastName;
    public TextField getEmail;
    public TextField getAddress;
    public TextField getAge;
    public TextField getPhoneNumber;

    public void displayFriendInfo(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        lblName.setText(temp.getFirstName() + " " + temp.getLastName());
        lblEmail.setText(temp.getEmailAddress());
        lblAddress.setText(temp.getHomeAddress());
        lblAge.setText(Integer.toString(temp.getAge()));
        lblPhoneNumber.setText(temp.getPhoneNumber());
        btnRemoveFriend.setDisable(false);

    }

    public void addFriend(ActionEvent actionEvent) {
        String first = getFirstName.getText();
        String last = getLastName.getText();
        String email = getEmail.getText();
        String address = getAddress.getText();
        int age = Integer.parseInt(getAge.getText());
        String phoneNumber = getPhoneNumber.getText();
        Friend temp = new Friend(first, last, email, address, age, phoneNumber);
        friendList.getItems().add(temp);
        getFirstName.clear();
        getLastName.clear();
        getEmail.clear();
        getAddress.clear();
        getAge.clear();
        getPhoneNumber.clear();
    }

    public void removeFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(temp);
        lblName.setText("                                                ");
        lblEmail.setText("                                                ");
        lblAddress.setText("                                           ");
        lblAge.setText("                                                ");
        lblPhoneNumber.setText("                                ");
        btnRemoveFriend.setDisable(true);
    }
}
