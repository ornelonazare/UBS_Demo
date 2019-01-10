package com.batch.employeedemo.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class LoadCSVData {

	public <T> List<T> readCSVFile(Class<T> entity, InputStream stream) throws IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(entity).withHeader().withColumnReordering(true);
		ObjectReader reader = mapper.readerFor(entity).with(schema);
		return reader.<T>readValues(stream).readAll();
	}

}
