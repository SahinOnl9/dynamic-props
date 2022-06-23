package poc.springdb.dynamicprops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import poc.springdb.dynamicprops.entity.Product;
import poc.springdb.dynamicprops.entity.ProductProps;
import poc.springdb.dynamicprops.repo.ProductPropsRepo;
import poc.springdb.dynamicprops.repo.ProductRepo;

@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ProductPropsRepo productPropsRepo;

	@Override
	public void run(String... args) throws Exception {

		for (int i = 1; i <= 100; i++) {
			Product product = Product.builder().productName("Product" + i).build();
			ProductProps props = ProductProps.builder().product(product).propA(100 + i).propB(200 + i).build();
			productRepo.save(product);
			productPropsRepo.save(props);
		}
	}

}
