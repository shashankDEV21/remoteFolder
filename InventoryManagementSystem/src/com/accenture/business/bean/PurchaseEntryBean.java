package com.accenture.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseEntryBean {

	private int purchaseEntryId;
	@NotBlank(message = "Required Field")
	private String materialCategoryId;
	@NotBlank(message = "Required Field")
	private String materialTypeId;
	@NotBlank(message = "Required Field")
	private String unitId;
	@NotBlank(message = "Required Field")
	private String brandId;
	@NotBlank(message = "Required Field")
	private String vendorId;
	//@NotEmpty(message = "Required Field")
	@NotNull(message = "Quantity Cannot be empty")
	@Range(min = 1,message = "Quantity cannot be less than 1.")
	private Integer quantity;
	//@NotEmpty(message = "Required Field")
	@NotNull(message = "Amount Cannot be empty")
	@Range(min = 1,message = "Amount cannot be less than 1.")
	private Double purchaseAmount;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date purchaseDate;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	private String transactionId;
	
	public String getMaterialTypeId() {
		return materialTypeId;
	}
	public void setMaterialTypeId(String materialTypeId) {
		this.materialTypeId = materialTypeId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public int getPurchaseEntryId() {
		return purchaseEntryId;
	}
	public void setPurchaseEntryId(int purchaseEntryId) {
		this.purchaseEntryId = purchaseEntryId;
	}
	public String getMaterialCategoryId() {
		return materialCategoryId;
	}
	public void setMaterialCategoryId(String materialId) {
		this.materialCategoryId = materialId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
}
