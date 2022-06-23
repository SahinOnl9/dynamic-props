package poc.springdb.dynamicprops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.springdb.dynamicprops.entity.ProductProps;

public interface ProductPropsRepo extends JpaRepository<ProductProps, Integer> {

}
