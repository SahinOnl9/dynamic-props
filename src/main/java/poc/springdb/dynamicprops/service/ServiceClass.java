package poc.springdb.dynamicprops.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.springdb.dynamicprops.dto.PageObj;
import poc.springdb.dynamicprops.entity.Product;
import poc.springdb.dynamicprops.repo.GenericRepo;
import poc.springdb.dynamicprops.repo.ProductRepo;

@Service
public class ServiceClass {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	GenericRepo genericRepo;

	public Object getAll() {
		List<Product> findAll = productRepo.findAll();
		return findAll;
	}

	BiFunction<Map<String, Object>, Map<String, Object>, Map<String, Object>> mapFunction = (elm, arg) -> {
		Map<String, Object> map = new HashMap<>();
		arg.forEach((k, v) -> map.put(k, elm.get(v)));
		return map;
	};
	BiConsumer<Map<String, Object>, Map<String, Object>> biConsumer = (elm, arg) -> {
		arg.forEach((k, v) -> arg.replace(k, elm.get(v)));
	};

	public Object getAllJdbc(PageObj obj) {
		Map<String, Object> mapped = new HashMap<>();
		mapped.put("name", "PRODUCT_NAME");
		mapped.put("a", "PROPA");
		mapped.put("b", "PROPB");

		List<Map<String, Object>> findAll = genericRepo.findAll(obj);
		List<Map<String, Object>> collect = findAll.stream().map(x -> mapFunction.apply(x, mapped))
				.collect(Collectors.toList());

		return collect;
	}
}
