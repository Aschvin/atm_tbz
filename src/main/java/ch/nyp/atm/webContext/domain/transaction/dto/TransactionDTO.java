package ch.nyp.atm.webContext.domain.transaction.dto;

import ch.nyp.atm.config.validation.notnull.NotNull;
import ch.nyp.atm.webContext.domain.user.User;
import ch.nyp.atm.webContext.domain.user.dto.UserATMDTO;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class TransactionDTO {

    @NotNull
    private int id;

    private UserATMDTO user1;

    private UserATMDTO user2;

    private double amount;
    private Boolean isSent;
    private Boolean isReceived;
    private Boolean isWithdrawed;
    private Boolean isDeposit;

    public TransactionDTO() {
    }

    public TransactionDTO(Integer id, UserATMDTO user1, UserATMDTO user2, double amount, Boolean isSent, Boolean isReceived, Boolean isWithdrawed, Boolean isDeposit) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.amount = amount;
        this.isSent = isSent;
        this.isReceived = isReceived;
        this.isWithdrawed = isWithdrawed;
        this.isDeposit = isDeposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserATMDTO getUser1() {
        return user1;
    }

    public void setUser1(UserATMDTO user1) {
        this.user1 = user1;
    }

    public UserATMDTO getUser2() {
        return user2;
    }

    public void setUser2(UserATMDTO user2) {
        this.user2 = user2;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    public Boolean getReceived() {
        return isReceived;
    }

    public void setReceived(Boolean received) {
        isReceived = received;
    }

    public Boolean getWithdrawed() {
        return isWithdrawed;
    }

    public void setWithdrawed(Boolean withdrawed) {
        isWithdrawed = withdrawed;
    }

    public Boolean getDeposit() {
        return isDeposit;
    }

    public void setDeposit(Boolean deposit) {
        isDeposit = deposit;
    }
}
