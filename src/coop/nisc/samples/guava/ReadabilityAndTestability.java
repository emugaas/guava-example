package coop.nisc.samples.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import coop.nisc.samples.guava.data.Data;
import coop.nisc.samples.guava.model.Customer;
import coop.nisc.samples.guava.model.Name;

import java.util.List;

/**
 * Created by emugaas on 2/17/2015.
 */
public class ReadabilityAndTestability {

    public static final Predicate<Customer> ACTIVE_CUSTOMERS = new CustomerStatusPredicate(Customer.Status.ACTIVE);
    public static final Predicate<Customer> INACTIVE_CUSTOMERS = new CustomerStatusPredicate(Customer.Status.INACTIVE);
    public static final Predicate<Customer> NOT_ACTIVE_CUSTOMERS = Predicates.not(ACTIVE_CUSTOMERS);
    public static final Predicate<Customer> ACTIVE_OR_INACTIVE_CUSTOMERS = Predicates.or(ACTIVE_CUSTOMERS, INACTIVE_CUSTOMERS);

    public static final Function<Customer, Name> CUSTOMER_TO_NAME = new CustomerToNameFunction();


    public static void main(String[] args) {

        List<Customer> customers = Data.getAllCustomers();

        List<Name> activeNames = FluentIterable.from(customers)
                .filter(ACTIVE_CUSTOMERS)
                .transform(CUSTOMER_TO_NAME).toList();

        System.out.println(Joiner.on("\n").join(activeNames));

    }


    public static class CustomerStatusPredicate implements Predicate<Customer> {
        private Customer.Status status;

        public CustomerStatusPredicate(Customer.Status status) {
            this.status = status;
        }

        @Override
        public boolean apply(Customer customer) {
            return status.equals(customer.getStatus());
        }
    }


    public static class CustomerToNameFunction implements Function<Customer, Name> {
        @Override
        public Name apply(Customer customer) {
            return new Name(customer.getFirstName(), customer.getLastName());
        }
    }
}
