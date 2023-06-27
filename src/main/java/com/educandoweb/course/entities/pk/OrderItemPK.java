package com.educandoweb.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable // Indica que uma classe é uma entidade embutida (embedded entity) em outra classe
public class OrderItemPK implements Serializable{ // Classe que será a classe auxiliar. Será a PK composta da tabela tb_order_item.
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id") // Define uma FK da tabela tb_order_item.
	private Order order; // Associação com a classe Order.
	
	@ManyToOne
	@JoinColumn(name = "product_id") // Define uma FK da tabela tb_order_item.
	private Product product; // Associação com a classe Product.
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

	
}
