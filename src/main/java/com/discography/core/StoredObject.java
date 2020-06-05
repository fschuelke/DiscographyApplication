package com.discography.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;

import com.discography.core.models.IModel;
import com.discography.xml.XMLParser;

public abstract class StoredObject {
	protected final List<IModel> content;

	public StoredObject() {
		content = new ArrayList<>();
	}

	public abstract void load(File file) throws JDOMException, IOException;
	public abstract void init();
	
	public void save(File file) throws JDOMException, IOException {
		XMLParser parser = new XMLParser(file);
		parser.write(content);
	}
	
}
