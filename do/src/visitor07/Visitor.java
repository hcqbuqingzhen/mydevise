package visitor07;

public interface Visitor {
    void visit(Customer customer);

    void visit(Order order);

    void visit(Item item);
}
