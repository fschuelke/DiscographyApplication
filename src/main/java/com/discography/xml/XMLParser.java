package com.discography.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.discography.core.models.IModel;
import com.discography.core.models.StringModel;

public class XMLParser {
	private File file;
	private Document doc;
	
	public XMLParser(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public XMLParser(String path) {
		this.file = new File(path);
	}
	
	public List<StringModel> load() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		ArrayList<StringModel> returnList = new ArrayList<>();
		doc = builder.build(file);
		
		for(Element element : doc.getRootElement().getChildren()) {
			StringModel model = new StringModel(element.getAttributeValue("name"));
			returnList.add(model);
		}
		
		return returnList;
	}
	
	public void write(List<IModel> list) throws IOException {
		XMLOutputter writer = new XMLOutputter();
		
		for(IModel model : list) {
			/*Element element = new Element("Model");
			Attribute nameAttrib = new Attribute("name", model.getName());*/
			Element element = model.getElement();
			element.setText(model.toStringModel().getValue());
		}
		
		writer.setFormat(Format.getPrettyFormat());
		writer.output(doc, new BufferedWriter(new FileWriter(file)));
	}
	
	public String getString(String element) {
		return doc.getRootElement().getChildText(element);
	}
	
	public boolean getBoolean(String element) {
		return Boolean.parseBoolean(getString(element));
	}
	
	public int getInt(String element) {
		return Integer.parseInt(getString(element));
	}
	
	public void setValue(String element, Object value) {
		doc.getRootElement().getChild(element).setText(value.toString());
	}
	
	public void setInt(String element, int value) {
		doc.getRootElement().getChild(element).setText(Integer.toString(value));
	}
	
	public void setBoolean(String element, boolean value) {
		doc.getRootElement().getChild(element).setText(Boolean.toString(value));
	}
}
