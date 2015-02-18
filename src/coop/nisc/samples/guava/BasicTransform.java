package coop.nisc.samples.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import coop.nisc.samples.guava.data.Data;
import coop.nisc.samples.guava.model.Customer;
import coop.nisc.samples.guava.model.Name;

import java.util.List;

/**
 * Created by emugaas on 2/17/2015.
 */
public class BasicTransform {

    public static void main(String[] args) {

        List<Customer> customers = Data.getAllCustomers();

        List<Name> names = Lists.transform(customers, new Function<Customer, Name>() {
            @Override
            public Name apply(Customer customer) {
                return new Name(customer.getFirstName(), customer.getLastName());
            }
        });

        System.out.println(Joiner.on("\n").join(names));
    }
}
