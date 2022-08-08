package com.example.order.factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.example.order.entity.Order;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvReader implements Reader {

	private CSVReader csvReader;

	private Order response = null;

	private static Pattern doublePattern = Pattern.compile("-?\\d+(\\.\\d*)?");

	public boolean isDouble(String string) {
		return doublePattern.matcher(string).matches();
	}

	@Override
	public List<Order> read(String file) {

		List<Order> result = new ArrayList<>();
		String[] nextRecord = null;

		try {
			FileReader filereader = new FileReader(file);

			csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			// we are going to read data line by line

			while ((nextRecord = csvReader.readNext()) != null) {
				response = new Order();
				if (nextRecord.length > 3) {
					if (StringUtils.isNotBlank(file))
						response.setFilename(file.contains("/") ? file.substring(file.lastIndexOf("/") + 1)
								: file.substring(file.lastIndexOf("\\") + 1));
					if (StringUtils.isNotBlank(nextRecord[0]) && isDouble(nextRecord[0])) {
						response.setOrderId(Long.parseLong(nextRecord[0]));
						response.setResult("OK");
					} else {
						response.setResult((isDouble(nextRecord[0]) == false)
								? " Number format exception occured while parsing order Id."
								: " error occured while parsing order id.");
					}
					if (StringUtils.isNotBlank(nextRecord[1]) && NumberUtils.isCreatable(nextRecord[1])) {
						response.setAmount(Float.parseFloat(nextRecord[1]));
					} else {
						response.setResult((isDouble(nextRecord[1]) == false)
								? " Number format exception occured while parsing order amount."
								: " error occured while parsing order amount.");
					}
					if (StringUtils.isNotBlank(nextRecord[2]) && StringUtils.isAlphanumeric(nextRecord[2])) {
						response.setCurrency(nextRecord[2]);
					} else {
						response.setResult(" error occured while parsing order currency.");
					}
					if (StringUtils.isNotBlank(nextRecord[3])) {
						response.setComment(nextRecord[3]);
					} else {
						response.setResult("error occured while parsing order.");
					}
					response.setId(csvReader.getRecordsRead());
					response.setLine(csvReader.getRecordsRead());
					result.add(response);
				}

			}

		} catch (NumberFormatException | IOException e) {
			response.setResult(e.getMessage().toString());
		}
		return result;
	}

}
