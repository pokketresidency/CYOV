package com.cyov.marketplace.model.entity.orderflow;

import com.cyov.marketplace.model.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "discount_coupon_used")
    private String discountCouponUsed;

    @Column(name = "total_discount")
    private BigDecimal totalDiscount;

    @Column(name = "final_amount_after_discount", nullable = false)
    private BigDecimal finalAmountAfterDiscount;


}
