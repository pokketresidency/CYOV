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
@Table(name = "refunds")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;

    @ManyToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

    @Column(name = "refunded_date", nullable = false)
    private LocalDateTime refundedDate;

    @Column(name = "refunded_amount", nullable = false)
    private BigDecimal refundedAmount;
}
