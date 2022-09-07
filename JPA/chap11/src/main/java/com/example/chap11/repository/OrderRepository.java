package com.example.chap11.repository;

import com.example.chap11.domain.Order;
import com.example.chap11.domain.QOrder;
import com.example.chap11.dto.OrderSearch;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.chap11.domain.QOrder.order;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        JPAQuery<Order> query = new JPAQuery<Order>(em);
        return query.from(order)
                .where(orderSearchBuilder(orderSearch))
                .stream().limit(1000)
                .collect(Collectors.toList());
    }

    private static BooleanBuilder orderSearchBuilder(OrderSearch orderSearch) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            builder.and(order.member.name.eq(orderSearch.getMemberName()));
        }
        if (orderSearch.getOrderStatus() != null) {
            builder.and(order.status.eq(orderSearch.getOrderStatus()));
        }
        return builder;
    }
}
