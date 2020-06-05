package com.discography.core.models;

import org.jdom2.Element;

public interface IModel {
	StringModel toStringModel();
	void parseModel(StringModel src);
	Element getElement();
	void parseElement(Element element) throws ModelParsingException;
}
