package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMethods {

    File groupsFile = new File("Groups.txt");

    public void writeGroupsToText(Group group) throws IOException {
        FileWriter fw = new FileWriter(groupsFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(group.toDataLine() + "\n");
        bw.flush();
        bw.close();
    }

    public List<Group> loadGroups() throws IOException {
        FileReader fr = new FileReader(groupsFile);
        BufferedReader br = new BufferedReader(fr);
        List<Group> groups = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            Group group = new Group(line);
            groups.add(group);
        }
        br.close();
        return groups;
    }

    public Group searchForGroup(String groupName) throws IOException {
        List<Group> groups = loadGroups();
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    public List<Friend> getFriends(Group group) throws IOException {
        List<Friend> friends = new ArrayList<>();
        FileReader fr = new FileReader(group.getFilename());
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            Friend friend = new Friend(line);
            friends.add(friend);
        }
        return friends;
    }

    public void writeFriendInText(Friend friend, Group group) throws IOException {
        File file = new File(group.getFilename());
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fr);
        bw.write(friend.toDataLine() + "\n");
        bw.flush();
        bw.close();
    }
}