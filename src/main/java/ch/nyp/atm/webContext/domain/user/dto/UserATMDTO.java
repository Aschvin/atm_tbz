package ch.nyp.atm.webContext.domain.user.dto;

import ch.nyp.atm.config.validation.notnull.NotNull;

public class UserATMDTO {
    @NotNull
    private String username;

    private String firstName;

    private String lastName;

    private double cash;

    public UserATMDTO() {
    }

    public UserATMDTO(String username, String firstName, String lastName, double cash) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }

    public UserATMDTO(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
