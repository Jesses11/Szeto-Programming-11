package sample;

public class Friend {
    String name = "";
    String email = "";
    String number = "";

    Friend(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public Friend(String line) {
        int indexOfComma = line.indexOf(',');
        int indexOfSemicolon = line.indexOf(';');
        name = line.substring(0, indexOfComma);
        email = line.substring(indexOfComma + 1, indexOfSemicolon);
        number = line.substring(indexOfSemicolon + 1);
    }

    public String toDataLine() {
        return name + "," + email + ";" + number;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nNumber: " + number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}