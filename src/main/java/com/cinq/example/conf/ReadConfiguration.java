package com.cinq.example.conf;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.util.HashMap;

public class ReadConfiguration {

	public static void main(String args[]) throws ConfigurationException {
		XMLConfiguration config = new XMLConfiguration("config.xml");
		System.out.println("Item1's value: " + config.getString("item1"));
		System.out.println("Item2's values: " + config.getList("item2"));
		System.out.println("Item2 2nd's value: " + config.getList("item2").get(1));
		System.out.println("Item3's keys: " + config.getList("item3.item.key"));
		System.out.println("Item3's values: " + config.getList("item3.item.value"));

		int counter = 0;
		int howMany = config.getList("item3.item.key").size();
		HashMap<String, String> map = new HashMap<String, String>();
		while ( counter < howMany ) {
			map.put(config.getString("item3.item(" + counter + ").key"), config.getString("item3.item(" + counter + ").value"));
			counter++;
		}
		System.out.println("We have " + map.size() + " elements in the map");
	}
}
