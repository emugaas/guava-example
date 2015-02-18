package coop.nisc.samples.guava;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import coop.nisc.samples.guava.data.Data;
import coop.nisc.samples.guava.model.Customer;

/**
 * Created by emugaas on 2/17/2015.
 */
public class MultiMapStructures {

    public static void main(String[] args) {

        System.out.println("***** new ListMultimap  *****");

        //much easier to work with than Map<String, List<String>>
        ListMultimap<String, String> map = ArrayListMultimap.create();
        map.put("a", "1");
        map.put("a", "2");
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));



        System.out.println("***** last name -> Customer *****");

        ListMultimap<String, Customer> lastNameToCustomer = Multimaps.index(Data.getAllCustomers(),
                new Function<Customer, String>() {
                    @Override
                    public String apply(Customer customer) {
                        return customer.getLastName();
                    }
                });

        System.out.println(lastNameToCustomer.get("Smith"));
        System.out.println(lastNameToCustomer.get("Mugaas"));

    }
}
