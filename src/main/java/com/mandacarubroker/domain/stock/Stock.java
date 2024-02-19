package com.mandacarubroker.domain.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table (name="stock")
@Entity(name="stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Stock {

  @Id @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  
  private String symbol;
  private String companyName;
  private Double price;
  
  public Stock(String id, String symbol, String companyName, Double price) {
    super();
    this.id = id;
    this.symbol = symbol;
    this.companyName = companyName;
    this.price = price;
  }

  public Stock(RequestStockDataTransferObject requestStock) {
    this.symbol = requestStock.symbol();
    this.companyName = requestStock.companyName();
    this.price = requestStock.price();
  }
  

  public String getId() {
    return id;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getCompanyName() {
    return companyName;
  }

  public double getPrice() {
    return price;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setPrice(double price) {
    this.price = price;
  }
   
public double changePrice(double amount, boolean increase) {
    if (amount < 0) {
      throw new IllegalArgumentException("The value cannot be negative.");
      }
    if (increase) {
      return increasePrice(amount);
    } else {
      if (amount < this.price) {
        return decreasePrice(amount);
      } else {
        return 0.00;
      }
    }
  }

  private double increasePrice(double amount) {
    return this.price + amount;
  }

  private double decreasePrice(double amount) {
    return this.price - amount;
  }

}