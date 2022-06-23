package poc.springdb.dynamicprops.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import poc.springdb.dynamicprops.dto.PageObj;

@Repository
public class GenericRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql = "select * from product a, product_props b where a.id = b.product_id limit %d offset %d";

	public List<Map<String, Object>> findAll(PageObj pageObj) {
		List<Map<String, Object>> queryForList = jdbcTemplate
				.queryForList(String.format(sql, pageObj.getSize(), pageObj.getOffset()));
		return queryForList;
	}
}
