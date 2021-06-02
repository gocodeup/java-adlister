package MvcLecture;


import java.util.List;

public interface Products {
    //here we provide the behaviors/methods // List Data types
    List<Product> all();
    void insert(Product product);
}
