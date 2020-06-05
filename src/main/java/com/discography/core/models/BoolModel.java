package com.discography.core.models;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class BoolModel extends Model<Boolean> {

	public BoolModel(String name, boolean value) {
		super(name, value);
	}
	
	/**
	 * default constructor sets value to false
	 * @param name Name
	 */
	public BoolModel(String name) {
		this(name, false);
	}
	
	@Override
	public StringModel toStringModel() {
		return new StringModel(name, value.toString());
	}

	@Override
	public void parseModel(StringModel src) {
		value = Boolean.parseBoolean(src.getValue());
	}

	@Override
	public Element getElement() {
		Element ret = new Element("Bool");
		ret.getAttributes().add(new Attribute("name", name));
		ret.setText(value.toString());
		return ret;
	}

	@Override
	public void parseElement(Element element) throws ModelParsingException {
		if( !element.getName().equals("Bool") )
			throw new ModelParsingException();
		
		name = element.getAttributeValue("name");
		value = Boolean.parseBoolean(element.getText());
	}
}
