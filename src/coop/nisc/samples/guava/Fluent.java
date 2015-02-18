package coop.nisc.samples.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import coop.nisc.samples.guava.data.Data;
import coop.nisc.samples.guava.model.Customer;
import coop.nisc.samples.guava.model.Name;

import java.util.List;

/**
 * Created by emugaas on 2/17/2015.
 */
public class Fluent {

    public static void main(String[] args) {

        List<Customer> customers = Data.getAllCustomers();

        List<Name> activeNames = FluentIterable.from(customers)
                .filter(new Predicate<Customer>() {
                    @Override
                    public boolean apply(Customer customer) {
                        return Customer.Status.ACTIVE.equals(customer.getStatus());
                    }
                })
                .transform(new Function<Customer, Name>() {
                    @Override
                    public Name apply(Customer customer) {
                        return new Name(customer.getFirstName(), customer.getLastName());
                    }
                }).toList();

        System.out.println(Joiner.on("\n").join(activeNames));

    }
}
