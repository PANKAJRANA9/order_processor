package com.example.order.factory;

import java.util.List;

import com.example.order.entity.Order;

public interface Reader {
	public static final long id = 1;

	public List<Order> read(String file);
}
