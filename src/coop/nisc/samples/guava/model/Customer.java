package coop.nisc.samples.guava.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by emugaas on 2/16/2015.
 */
public class Customer {
    public enum Status{ACTIVE, INACTIVE, POTENTIAL}

    private Long customerNumber;
    private String firstName;
    private String lastName;
    private Status status;
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(Long customerNumber, String firstName, String lastName, Status status, List<Account> accounts) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.accounts = accounts;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("customerNumber", customerNumber)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("status", status)
                .add("accounts", accounts)
                .toString();
    }
}
