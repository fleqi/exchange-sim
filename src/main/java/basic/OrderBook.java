package basic;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.TreeMap;

public class OrderBook {
    private final TreeMap<Long, ArrayDeque<Order>> bids, asks;

    public OrderBook() {
        this.bids = new TreeMap<>(Comparator.reverseOrder());
        this.asks = new TreeMap<>();
    }

    private TreeMap<Long, ArrayDeque<Order>> book(Side side) {
        return switch (side) {
            case BUY -> bids;
            case SELL -> asks;
        };
    }

    public void addOrder(Order order) {
        TreeMap<Long, ArrayDeque<Order>> map = book(order.getSide());
        ArrayDeque<Order> row = map.get(order.getPrice());
        if (row == null) {
            row = new ArrayDeque<>();
            map.put(order.getPrice(), row);
        }
        row.addLast(order);
    }


    public boolean isEmpty(Side side) {
        return book(side).isEmpty();
    }

    public boolean removeOrder(Order order) {
        TreeMap<Long, ArrayDeque<Order>> map = book(order.getSide());
        ArrayDeque<Order> row = map.get(order.getPrice());
        if (row == null) return false;
        boolean success = row.remove(order); // O(n), change later
        if (row.isEmpty()) map.remove(order.getPrice());
        return success;
    }

    public Order bestOrder(Side side) {
        if (isEmpty(side)) return null;
        return book(side).firstEntry().getValue().getFirst();
    }
}
