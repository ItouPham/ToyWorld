package com.MyProject.ToyWorld.dto.admin;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.math.BigDecimal;

public class AddNewProductDTO {

    private String productName;

    private String productDescription;

    private Integer size;

    private BigDecimal price;

    private Integer quantity;

    private Long categoryID;

    private String productImage;

    private MultipartFile imageFile;

    public AddNewProductDTO() {
    }

    public AddNewProductDTO(String productName, String productDescription, Integer size, BigDecimal price, Integer quantity, Long categoryID, String productImage, MultipartFile imageFile) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.productImage = productImage;
        this.imageFile = imageFile;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getCategoryID() {
        return categoryID;
    }


    public String getProductImage() {
        return productImage;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "AddNewProductDTO{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryID=" + categoryID +
                '}';
    }
}
