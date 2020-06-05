package com.discography.core;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;

import com.discography.core.models.BoolModel;
import com.discography.core.models.StringModel;
import com.discography.xml.XMLParser;

public class Settings extends StoredObject {
	private BoolModel autologin;
	
	public Settings() {
		autologin = new BoolModel("autologin");
	}

	/**
	 * reads a list of StringModels and parses members
	 * then, calls init to add the parsed models to the list
	 */
	@Override
	public void load(File file) throws JDOMException, IOException {
		XMLParser parser = new XMLParser(file);
		
		for(StringModel model : parser.load()) {
			if(model.getName().equals(autologin.getName())) {
				autologin.parseModel(model);
			}
		}
		init();
	}

	@Override
	public void init() {
		content.add(autologin);		
	}
}
