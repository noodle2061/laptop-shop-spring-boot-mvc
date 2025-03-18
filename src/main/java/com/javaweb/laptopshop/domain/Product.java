package com.javaweb.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Đảm bảo tên sản phẩm không bị null hoặc rỗng
    @NotBlank(message = "Product name is required")
    @Column(name = "name")
    private String name;

    // Giá sản phẩm phải lớn hơn 0
    @DecimalMin(value = "0.0", inclusive = false, message = "Product price must be greater than 0")
    @Column(name = "price")
    private double price;

    @Column(name = "image")
    private String image;

    // Mô tả chi tiết, sử dụng MEDIUMTEXT
    @Column(name = "detail_desc", columnDefinition = "MEDIUMTEXT")
    private String detailDesc;

    @Column(name = "short_desc")
    private String shortDesc;

    // Số lượng không âm
    @Min(value = 0, message = "Quantity must not be negative")
    @Column(name = "quantity")
    private long quantity;

    // Số lượng bán ra không âm
    @Min(value = 0, message = "Sold quantity must not be negative")
    @Column(name = "sold")
    private long sold;

    // Nhà sản xuất không được để trống
    @NotBlank(message = "Factory is required")
    @Column(name = "factory")
    private String factory;

    // Đối tượng khách hàng không được để trống
    @NotBlank(message = "Target audience is required")
    @Column(name = "target")
    private String target;

    // Thêm lại trường Category
    @Column(name = "category")
    private String category;

    // Nếu bạn có OrderDetail, liên kết OneToMany
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetail;

    // Constructor mặc định
    public Product() {
    }

    // Constructor đầy đủ (không kèm id vì id tự tăng)
    public Product(
            String name,
            double price,
            String image,
            String detailDesc,
            String shortDesc,
            long quantity,
            long sold,
            String factory,
            String target,
            String category
    ) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.detailDesc = detailDesc;
        this.shortDesc = shortDesc;
        this.quantity = quantity;
        this.sold = sold;
        this.factory = factory;
        this.target = target;
        this.category = category;
    }

    // Getter/Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
