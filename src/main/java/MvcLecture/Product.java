package MvcLecture;

public class Product {
    private String name; //fields(informed by the entity
    private double price;//fields

    public Product(){
        //empty constructor always necessary
    }
    public Product(String name, double price){
        this.name = name;
        this.price=price;
    }//filled constructor
}
