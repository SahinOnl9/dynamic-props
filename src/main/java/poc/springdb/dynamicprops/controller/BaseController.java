package poc.springdb.dynamicprops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poc.springdb.dynamicprops.dto.PageObj;
import poc.springdb.dynamicprops.service.ServiceClass;

@RestController
public class BaseController {

	@Autowired
	ServiceClass serviceClass;

	@GetMapping("/get-all")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(serviceClass.getAll());
	}

	@PostMapping("/get-all")
	public ResponseEntity<Object> getAllJdbc(@RequestBody PageObj obj) {
		return ResponseEntity.ok(serviceClass.getAllJdbc(obj));
	}
}
