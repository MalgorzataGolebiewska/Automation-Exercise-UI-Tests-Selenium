package models;

import lombok.Getter;

@Getter
public class UserData {

    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String firstAddress;
    private String secondAddress;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;

    public UserData() {
        this.name = "test";
        this.email = "automated.testinvx@gmail.com";
        this.password = "testowy";
        this.firstName = "Tester";
        this.lastName = "Testowy";
        this.company = "HelloWorld";
        this.firstAddress = "Riverview 23, Sunset Valley";
        this.secondAddress = "Lucky Palms 59, Twinbrook";
        this.state = "Isla Paradiso";
        this.city = "Bridgeport";
        this.zipcode = "00-000";
        this.mobileNumber = "123456789";
    }

}
