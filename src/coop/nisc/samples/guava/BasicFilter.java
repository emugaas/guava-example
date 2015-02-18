package coop.nisc.samples.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import coop.nisc.samples.guava.data.Data;
import coop.nisc.samples.guava.model.Customer;

import java.util.List;

public class BasicFilter {

    public static void main(String[] args) {

	    List<Customer> customers = Data.getAllCustomers();

        Iterable<Customer> activeCustomers = Iterables.filter(customers, new Predicate<Customer>() {
            @Override
            public boolean apply(Customer customer) {
                return Customer.Status.ACTIVE.equals(customer.getStatus());
            }
        });

        System.out.println(Joiner.on("\n").join(activeCustomers));
    }
}
