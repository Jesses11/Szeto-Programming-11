package sample;

public class Friend {
    public String firstName;
    public String lastName;
    public String emailAddress;
    private String homeAddress;
    private int age;
    private String phoneNumber;

    Friend(String first, String last, String email, String address, int age, String number){
        firstName = first;
        lastName = last;
        emailAddress = email;
        homeAddress = address;
        this.age = age;
        phoneNumber = number;
    }

    //getters and setters

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    public String getEmailAddress(){return emailAddress;}
    public void setEmailAddress(String emailAddress){this.emailAddress = emailAddress;}

    public String getHomeAddress(){return homeAddress;}
    public void setHomeAddress(String homeAddress){this.homeAddress = homeAddress;}

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}

    public String getPhoneNumber(){return phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}


    public String toString(){
        return firstName + " " + lastName;
    }






}
