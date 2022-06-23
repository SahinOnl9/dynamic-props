package poc.springdb.dynamicprops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.springdb.dynamicprops.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
