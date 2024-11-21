package com.vmware.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONFileWriter {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		ObjectMapper objMapper=new ObjectMapper();
		ObjectNode objectNode = objMapper.createObjectNode();
		objectNode.put("Ramu", 300);
		objectNode.put("Kamu", 200);
		objectNode.put("Tamu", 900);
		objectNode.put("Lalli", 100);
		objectNode.put("Raghu", 300);
		objMapper.writeValue(new File("/Users/armaansyed/Downloads/employee.json"), objectNode);
	}

}
