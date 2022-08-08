package com.example.order.factory;

public class ReaderFactory {

	public Reader createFileReader(String filename) {
		if (filename == null || filename.isEmpty())
			return null;
		switch (filename.substring(filename.lastIndexOf(".")).toLowerCase()) {
		case ".csv":
			return new CsvReader();
		case ".json":
			return new JsonReader();
		default:
			throw new IllegalArgumentException("Unknown filename  " + filename);
		}
	}

}
