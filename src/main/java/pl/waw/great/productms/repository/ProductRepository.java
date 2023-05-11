package pl.waw.great.productms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.great.productms.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    @Override
    List<Product> findAll();
}
