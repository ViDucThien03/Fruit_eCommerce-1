package com.spring.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailMapper implements RowMapper<OrderDetail> {
    @Override
    public OrderDetail mapRow(ResultSet rs, int i) throws SQLException {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(rs.getInt("id"));
        orderDetail.setTotalPiad(rs.getDouble("total_piad"));
        orderDetail.setDeliveryStatus(rs.getString("status"));
        orderDetail.setOrderID(rs.getInt("order_id"));

        // Assuming that OrdersMapper is another RowMapper for the Orders class
        OrderMapper ordersMapper = new OrderMapper();
        Orders order = ordersMapper.mapRow(rs, i);
        orderDetail.setOrder(order);
        return orderDetail;
    }
}
