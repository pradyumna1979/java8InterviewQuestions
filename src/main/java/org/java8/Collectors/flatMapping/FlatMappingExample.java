package org.java8.Collectors.flatMapping;

import org.java8.model.LineItem;
import org.java8.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMappingExample {
    /*
    For example, given a stream of Order, to accumulate the set of line items for each customer:
     */
    public static void main(String[] args) {
        Order order1 = new Order("customer1", List.of(new LineItem("item1"), new LineItem("item1")));
        Order order2 = new Order("customer2", List.of(new LineItem("item1"), new LineItem("item2")));
        Order order3 = new Order("customer1", List.of(new LineItem("item1"), new LineItem("item1")));
        Order order4 = new Order("customer1", List.of(new LineItem("item1"), new LineItem("item1")));
        Map<String, Set<LineItem>> map = getLineItemsByCustomer(List.of(order1, order2, order3, order4));
        System.out.println(map);
    }

    private static Map<String, Set<LineItem>> getLineItemsByCustomer(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.flatMapping(order -> order.getLineItems().stream(), Collectors.toSet())
                        )
                );
    }
}
