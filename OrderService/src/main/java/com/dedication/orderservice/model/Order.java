package com.dedication.orderservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_orders")
public class Order {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String orderNumber;
		
		
		@OneToMany(cascade = CascadeType.ALL)
		private List<OrderLineItems> orderLineItemList;
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getOrderNumber() {
			return orderNumber;
		}

		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}

		public List<OrderLineItems> getOrderLineItemList() {
			return orderLineItemList;
		}

		public void setOrderLineItemList(List<OrderLineItems> orderLineItemList) {
			this.orderLineItemList = orderLineItemList;
		}
		
		
			
}
