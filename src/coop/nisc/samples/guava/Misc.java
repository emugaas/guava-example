package coop.nisc.samples.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.Callables;
import coop.nisc.samples.guava.data.Data;
import coop.nisc.samples.guava.model.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by emugaas on 2/17/2015.
 */
public class Misc {

    public static void main(String[] args) {
        System.out.println("**** Joiner *****");
        joiner();

        System.out.println("\n**** toStringHelper *****");
        toStringHelper();

        System.out.println("\n**** ComparisonChain *****");
        comparisionChain();

        System.out.println("\n**** Preconditions *****");
        preconditions();

        System.out.println("\n**** Splitter *****");
        splitter();

        System.out.println("\n**** CacheBuilder *****");
        cacheBuilder();


    }

    private static void joiner(){
        String result = Joiner.on(",").skipNulls().join("a", "b", null, "c", "", "d");
        System.out.println(result);
    }

    private static void toStringHelper(){
        Customer c = Iterables.getFirst(Data.getAllCustomers(), null);
        System.out.println(c.toString());
    }

    private static void comparisionChain(){

        List<Customer> sortedCustomers = Ordering.from(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return ComparisonChain.start()
                        .compare(o1.getLastName(), o2.getLastName())
                        .compare(o1.getFirstName(), o2.getFirstName())
                        .compare(o1.getCustomerNumber(), o2.getCustomerNumber())
                        .result();
            }
        }).sortedCopy(Data.getAllCustomers());

        System.out.println(Joiner.on("\n").join(sortedCustomers));

    }

    private static void preconditions(){
        try {
            String value = null;//whoops, forgot to give it a value ;)
            notNull(value);
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            for (Customer customer : Data.getAllCustomers()){ //whoops, probably should have filtered to only get active customers
                mustBeActiveCustomer(customer);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void notNull(String argument){
        Preconditions.checkNotNull(argument);
        //do stuff
    }

    private static void mustBeActiveCustomer(Customer customer){
        Preconditions.checkNotNull(customer);
        Preconditions.checkArgument(Customer.Status.ACTIVE.equals(customer.getStatus()), "Method called with non-active customer!");
        //do stuff
    }


    private static void splitter(){
        Iterable<String> results = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split("a,b,, c , , d,");

        for (String result: results) {
            System.out.println(result);
        }
    }

    private static void cacheBuilder(){
        //a cache would not typically be a method variable, it would be more useful as a singleton
        //or some other managed scope that multiple threads or business processes could utilize
        Cache<Long, String> cache =
                CacheBuilder.newBuilder()
                .concurrencyLevel(3)
                .maximumSize(10)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .recordStats()
                .build();

        System.out.println(cache.getIfPresent(1l));

        cache.put(1l, "one!");

        System.out.println(cache.getIfPresent(1l));

        try {
            //specifying a callable to load the value from if it isn't currently in the cache
            System.out.println(cache.get(2l, Callables.returning("two!")));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(cache.getIfPresent(2l));

        System.out.println(cache.stats());

    }
}
