package coop.nisc.samples.guava;

import com.google.common.collect.Iterables;
import coop.nisc.samples.guava.data.Data;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HomeworkTest {

    @Test
    public void testGetFullNamesForCustomersWithExactlyOneAccount() throws Exception {
        Homework hw = new Homework();

        Iterable<String> names = hw.getFullNamesForCustomersWithExactlyOneAccount(Data.getAllCustomers());

        assertArrayEquals(
                new Object[]{"Haggard, Johana", "Sidle, Cheryll", "Smith, Bob"},
                Iterables.toArray(names, Object.class));
    }
}