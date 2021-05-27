package com.ust.pms.model;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



  @Getter  
  @Setter  
  
  @ToString
  @EqualsAndHashCode
  
  @NoArgsConstructor //default constructor  
  @RequiredArgsConstructor //default constructor
  @AllArgsConstructor


//@Data

public class Product {
	
	
	private @NonNull int productId;
	private String productName;	
	
	//private final @Getter(value = AccessLevel.PRIVATE) String productName = "";
	
	private @NonNull int quantityOnHand;
	private @NonNull int price;	
	
	
	 

}
