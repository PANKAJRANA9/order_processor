package com.example.order.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.order.entity.Order;

public class FileUtils {

	public static String readFileAsString(String filePath) {

		String content = null;
		try {
			content = Files.lines(Paths.get(filePath)).collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static String getFilePath(String filename) {
		Path currentRelativePath = Paths.get("");
		String abspath = currentRelativePath.toAbsolutePath().toString();
		return abspath + "/" + filename;
	}

	public static List<Order> mergeList(List<Order> l1, List<Order> l2) {
		if (l1 != null && l2 != null) {
			List<Order> result = new ArrayList<>();
			result.addAll(l1);
			result.addAll(l2);
			int rowId = 1;
			for (Order r : result) {
				r.setId(rowId++);
			}

			return result;
		} else
			return null;

	}
}
