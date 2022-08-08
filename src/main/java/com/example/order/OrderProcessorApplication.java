package com.example.order;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.order.entity.Order;
import com.example.order.factory.Reader;
import com.example.order.factory.ReaderFactory;
import com.example.order.util.FileUtils;

@SpringBootApplication
public class OrderProcessorApplication {

	public static void main(String[] args) {
		//SpringApplication.run(OrderProcessorApplication.class, args);
		try {
		String firstArgumentFile = args[0];
		String secondFileArgument = args[1];
		if(StringUtils.isNotEmpty(firstArgumentFile) &&  StringUtils.isNotEmpty(firstArgumentFile))
		 {
			//System.out.println(firstArgumentFile);
		 
		String csvPath = FileUtils.getFilePath(firstArgumentFile);
		//System.out.println(csvPath);
		ReaderFactory f = new ReaderFactory();
		Reader createFileReader = f.createFileReader(firstArgumentFile);
		
		Reader csvFileReader = f.createFileReader(secondFileArgument);
		String jsonPath = FileUtils.getFilePath(secondFileArgument);
		//String filePath = FileUtils.getFilePath("order1.csv");
		//String filePath1 = FileUtils.getFilePath("order.json");
		//System.out.println(filePath);
		List<Order> read = createFileReader.read( csvPath);
		
		//System.out.println(read);
		List<Order> read2 = csvFileReader.read(jsonPath);
		
		List<Order> mergeList = FileUtils.mergeList(read,read2);
		mergeList.forEach(s->System.out.println(s));
		 
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("File argument is missing.");
			
		}
		
	}

}
