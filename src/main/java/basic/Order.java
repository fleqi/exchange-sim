package basic;

public class Order {
    private final long id;
    private final long traderId;
    private final Side side;
    private final long price;
    private final long quantity;
    private final long timestamp;
    private long remaining;

    public Order(long id, long traderId, Side side, long price, long quantity, long timestamp) {
        this.id = id;
        this.traderId = traderId;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.remaining = quantity;
    }

    public long getId() {
        return id;
    }

    public long getTraderId() {
        return traderId;
    }

    public long getPrice() {
        return price;
    }

    public Side getSide() {
        return side;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getFilled() {
        return quantity - remaining;
    }

    public long getRemaining() {
        return remaining;
    }

    public boolean isFilled() {
        return remaining == 0;
    }

    public void fill(long qty) {
        if (qty <= 0) throw new IllegalArgumentException("Fill quantity must be positive");
        else if (qty > remaining) throw new IllegalArgumentException("Fill quantity must be less than or equal to remaining quantity");
        else remaining -= qty;
    }

}
