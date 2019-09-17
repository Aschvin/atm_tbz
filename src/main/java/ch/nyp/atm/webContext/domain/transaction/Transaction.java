package ch.nyp.atm.webContext.domain.transaction;

import ch.nyp.atm.webContext.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user1_id")
    private User user1;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user2_id")
    private User user2;
    @Column
    private double amount;
    @Column
    private Boolean isSent;
    @Column
    private Boolean isReceived;
    @Column
    private Boolean isWithdrawed;
    @Column
    private Boolean isDeposit;

    public Transaction() {
    }

    public Transaction(int id, User user1, User user2, double amount, Boolean isSent, Boolean isReceived, Boolean isWithdrawed, Boolean isDeposit) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.amount = amount;
        this.isSent = isSent;
        this.isReceived = isReceived;
        this.isWithdrawed = isWithdrawed;
        this.isDeposit = isDeposit;
    }

    public Transaction(User user1, User user2, double amount, Boolean isSent, Boolean isReceived, Boolean isWithdrawed, Boolean isDeposit) {
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
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