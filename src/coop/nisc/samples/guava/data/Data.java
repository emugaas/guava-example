package coop.nisc.samples.guava.data;

import com.google.common.collect.Lists;
import coop.nisc.samples.guava.model.Account;
import coop.nisc.samples.guava.model.Customer;

import java.util.List;

/**
 * Created by emugaas on 2/16/2015.
 */
public class Data {

    public static List<Customer> getAllCustomers(){

        return Lists.newArrayList(
                new Customer(1l, "Bob", "Smith",
                        Customer.Status.ACTIVE, Lists.newArrayList(new Account(500l, "Main"))),
                new Customer(2l, "Terry", "Rusch",
                        Customer.Status.ACTIVE, Lists.newArrayList(new Account(550l, "Home"),
                                           new Account(560l, "Lake House"))),
                new Customer(3l, "Cheryll", "Sidle",
                        Customer.Status.INACTIVE, Lists.newArrayList(new Account(510l, "Main"))),
                new Customer(4l, "Martin", "Bradway",
                        Customer.Status.ACTIVE, Lists.newArrayList(new Account(550l, "Primary"),
                                           new Account(450l, "Childs Account"))),
                new Customer(5l, "Rossana", "Smith",
                        Customer.Status.POTENTIAL, Lists.<Account>newArrayList()),
                new Customer(6l, "Johana", "Haggard",
                        Customer.Status.INACTIVE, Lists.newArrayList(new Account(480l, "Main")))
        );
    }

}
