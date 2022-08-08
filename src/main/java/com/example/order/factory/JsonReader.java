package com.example.order.factory;

import java.util.Arrays;
import java.util.List;

import com.example.order.entity.Order;
import com.example.order.util.FileUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class JsonReader implements Reader {

	@Override
	public List<Order> read(String file) {

		JsonArray data = new JsonArray();
		data.add(FileUtils.readFileAsString(file));
		Gson gson = new Gson();
		Order[] order = gson.fromJson(data.deepCopy().getAsString(), Order[].class);
		long rowId = 1;
		for (Order o : order) {
			o.setResult("OK");
			o.setFilename(file.substring(file.lastIndexOf("/") + 1));
			o.setId(rowId++);
			o.setLine(o.getId());
		}
		return Arrays.asList(order);
	}

}
