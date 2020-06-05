package com.discography.core.models;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class IntModel extends Model<Integer> {
	public IntModel(String name, int value) {
		super(name, value);
	}
	
	public IntModel(String name) {
		this(name, 0);
	}

	@Override
	public StringModel toStringModel() {
		return new StringModel(name, value.toString());
	}

	@Override
	public void parseModel(StringModel src) {
		value = Integer.parseInt(src.getValue());
	}

	@Override
	public Element getElement() {
		Element ret = new Element("Int");
		ret.getAttributes().add(new Attribute("name", name));
		ret.setText(value.toString());
		return null;
	}

	@Override
	public void parseElement(Element element) throws ModelParsingException {
		if( !element.getName().equals("Int") ) {
			throw new ModelParsingException();
		}
		name = element.getAttributeValue("name");
		value = Integer.parseInt(element.getText());
	}	
}
