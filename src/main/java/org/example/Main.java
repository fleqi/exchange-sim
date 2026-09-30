package org.example;

import basic.Order;
import basic.OrderBook;
import basic.Side;

import static java.lang.IO.println;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Order order = new Order(1, 1, Side.BUY, 5, 5, 2);
        order.fill(1);
        println(order.getFilled());
        order.fill(4);
        println(order.getFilled());
        println(order.isFilled());

        OrderBook book = new OrderBook();
        println(book.isEmpty(Side.BUY));
    }
}
