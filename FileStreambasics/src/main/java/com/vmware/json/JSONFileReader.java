package com.vmware.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JSONFileReader {

	public static void main(String[] args) throws IOException {
		JSONFileReader reader = new JSONFileReader();
		File file = new File("/Users/armaansyed/Downloads/student.json");
		ObjectMapper objMapper = new ObjectMapper();

		//Using fieldNames()
		List<String> list1 = reader.getKeysInJsonUsingJsonNodeFieldNames(file, objMapper);
		System.out.println("keys_In_Json_Using_JsonNode_FieldNames: " + list1);
		List<String> list2 = reader.getAllKeysInJsonUsingJsonNodeFieldNames(file, objMapper);
		System.out.println("All_keys_In_Json_Using_JsonNode_FieldNames: " + list2);

		//Using fields()
		List<String> list3 = reader.getAllKeysInJsonUsingJsonNodeFields(file, objMapper);
		System.out.println("All_keys_In_Json_Using_JsonNode_Fields: " + list3);
	}

	public List<String> getKeysInJsonUsingJsonNodeFieldNames(File file, ObjectMapper mapper) throws IOException {
		List<String> keys = new ArrayList<>();
		JsonNode jsonNode = mapper.readTree(file);
		Iterator<String> iterator = jsonNode.fieldNames();
		iterator.forEachRemaining(e -> keys.add(e));
		return keys;
	}

	public List<String> getAllKeysInJsonUsingJsonNodeFieldNames(File file, ObjectMapper mapper) throws IOException {
		List<String> keys = new ArrayList<>();
		JsonNode jsonNode = mapper.readTree(file);
		getAllKeysUsingJsonNodeFieldNames(jsonNode, keys);
		return keys;
	}

	public List<String> getAllKeysInJsonUsingJsonNodeFields(File file, ObjectMapper mapper) throws IOException {

		List<String> keys = new ArrayList<>();
		JsonNode jsonNode = mapper.readTree(file);
		getAllKeysUsingJsonNodeFields(jsonNode, keys);
		return keys;
	}

	private void getAllKeysUsingJsonNodeFields(JsonNode jsonNode, List<String> keys) {

		if (jsonNode.isObject()) {
			Iterator<Entry<String, JsonNode>> fields = jsonNode.fields();
			fields.forEachRemaining(field -> {
				keys.add(field.getKey());
				getAllKeysUsingJsonNodeFieldNames((JsonNode) field.getValue(), keys);
			});
		} else if (jsonNode.isArray()) {
			ArrayNode arrayField = (ArrayNode) jsonNode;
			arrayField.forEach(node -> {
				getAllKeysUsingJsonNodeFieldNames(node, keys);
			});
		}

	}

	private void getAllKeysUsingJsonNodeFieldNames(JsonNode jsonNode, List<String> keys) {

		if (jsonNode.isObject()) {
			Iterator<String> fieldNames = jsonNode.fieldNames();
			fieldNames.forEachRemaining(fieldName -> {
				keys.add(fieldName);
				getAllKeysUsingJsonNodeFieldNames(jsonNode.get(fieldName), keys);
			});
		} else if (jsonNode.isArray()) {
			ArrayNode arrayField = (ArrayNode) jsonNode;
			arrayField.forEach(node -> {
				getAllKeysUsingJsonNodeFieldNames(node, keys);
			});
		}

	}

}
