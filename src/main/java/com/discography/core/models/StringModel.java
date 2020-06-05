package com.discography.core.models;
import org.jdom2.Attribute;
import org.jdom2.Element;

public class StringModel extends Model<String> {
	public StringModel(String name, String value) {
		super(name);
		this.value = value;
	}
	
	public StringModel(String name) {
		this(name, "");
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public StringModel toStringModel() {
		return this;
	}

	@Override
	public void parseModel(StringModel src) {
		value = src.getValue();
	}

	@Override
	public Element getElement() {
		Element ret = new Element("String");
		ret.getAttributes().add(new Attribute("name", name));
		ret.setText(value);
		return ret;
	}

	@Override
	public void parseElement(Element element) throws ModelParsingException {
		if( !element.getName().equals("String") ) {
			throw new ModelParsingException();
		}
		name = element.getAttributeValue("name");
		value = element.getText();
	}
}
