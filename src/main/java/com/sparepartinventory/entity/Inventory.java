package com.sparepartinventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long partNumber;
	private String partDescription;
	private String supplierName;
	private Integer quantityInStock;
	private Integer minimumStockLevel;
	private Integer costPerUnit;
	private String locationInWarehouse;

}
