package com.kajal.api.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity @Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull private String productName;
    
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    public Long getId(){ return id; } public void setId(Long id){ this.id=id; }
    public String getProductName(){ return productName; } public void setProductName(String p){ this.productName=p; }
    public User getUser(){ return user; } public void setUser(User user){ this.user=user; }
}
