package coop.nisc.samples.guava.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by emugaas on 2/16/2015.
 */
public class Account {

    private Long accountNumber;
    private String accountAlias;

    public Account() {
    }

    public Account(Long accountNumber, String accountAlias) {

        this.accountNumber = accountNumber;
        this.accountAlias = accountAlias;
    }

    public Long getAccountNumber() {

        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountAlias() {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("accountNumber", accountNumber)
                .add("accountAlias", accountAlias)
                .toString();
    }
}
