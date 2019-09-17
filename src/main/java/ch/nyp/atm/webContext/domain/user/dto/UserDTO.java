package ch.nyp.atm.webContext.domain.user.dto;

import ch.nyp.atm.config.DateTimeUtil;
import ch.nyp.atm.config.generic.ExtendedDTO;
import ch.nyp.atm.config.validation.notnull.NotNull;
import ch.nyp.atm.config.validation.password.Password;

import javax.validation.constraints.Email;
import java.time.LocalDate;

//https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg

public class UserDTO extends ExtendedDTO {

    @NotNull
    private String username;

    @Password
    private String password;

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

    private double cash;

    @Email
    private String email;

    private int age;

    public UserDTO() {
        super();
    }

    public UserDTO(Long id) {
        super(id);
    }

    public UserDTO(
            Long id, String username, String password, String firstName, String lastName, LocalDate birthdate, String email
    ) {
        this(id);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Parses the birth date from a String
     * @param birthdateString The birth date as a String
     */
    public void setBirthdate(String birthdateString) {
        this.birthdate = DateTimeUtil.parseLocalDate(birthdateString);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
