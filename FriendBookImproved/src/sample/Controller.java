package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class Controller {

    public TextField getGroupName;
    public Button btnAddGroup;
    public ListView<String> groupList;
    public Button btnLoadGroups;

    public TextField getFriendName;
    public TextField getEmail;
    public TextField getPhone;
    public Label selectedGroup;

    public Button btnAddFriend;
    public ListView<String> friendsList;
    public Button btnLoadFriends;

    List<Group> groups = null;

    FileMethods fileMethods = new FileMethods();

    public void addGroup(ActionEvent actionEvent) throws IOException {
        String groupNameText = getGroupName.getText();
        if (groupNameText != null && !groupNameText.isEmpty()) {
            Group group = new Group(
                    groupNameText,
                    "group." + groupNameText.replaceAll(" ", "") + ".txt"
            );
            fileMethods.writeGroupsToText(group);
            getGroupName.clear();
            loadGroups(actionEvent);
        }
    }

    public void selectGroup(MouseEvent mouseEvent) {
        String selectedName = groupList.getSelectionModel().getSelectedItem();
        selectedGroup.setText(selectedName);
        btnAddFriend.setDisable(false);
        btnLoadFriends.setDisable(false);
        getFriendName.setDisable(false);
        getEmail.setDisable(false);
        getPhone.setDisable(false);
    }

    public void loadGroups(ActionEvent actionEvent) throws IOException {
        groupList.getItems().clear();
        groups = fileMethods.loadGroups();
        List<String> names = Group.convertGroupsToNames(groups);
        ObservableList<String> observableList = FXCollections.observableArrayList(names);
        groupList.setItems(observableList);
    }

    public void addFriend(ActionEvent actionEvent) throws IOException {
        String groupName = selectedGroup.getText();
        Group group = fileMethods.searchForGroup(groupName);
        if(group == null){
            return;
        }
        String name = getFriendName.getText();
        String email = getEmail.getText();
        String number = getPhone.getText();
        Friend friend = new Friend(name, email, number);
        fileMethods.writeFriendInText(friend, group);
        getFriendName.clear();
        getEmail.clear();
        getPhone.clear();
        btnAddFriend.setDisable(true);
        getFriendName.setDisable(true);
        getEmail.setDisable(true);
        getPhone.setDisable(true);
    }

    public void loadFriends(ActionEvent actionEvent) throws IOException {
        friendsList.getItems().clear();
        String groupName = selectedGroup.getText();
        Group group = fileMethods.searchForGroup(groupName);
        if (group == null){
            return;
        }
        List<Friend> friends = fileMethods.getFriends(group);
        for (Friend friend: friends){
            friendsList.getItems().add(friend.toString());
        }
        btnLoadFriends.setDisable(true);

    }
}
