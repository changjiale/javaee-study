package live.leer.spring.demo4;

public class Car {

    private String name;
    private Double price;

    public Car(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", price=" + price + "]";
    }
}
