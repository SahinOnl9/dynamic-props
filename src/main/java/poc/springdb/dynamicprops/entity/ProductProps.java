package poc.springdb.dynamicprops.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductProps {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int propA;
	private int propB;

	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	@JsonBackReference
	private Product product;

}
