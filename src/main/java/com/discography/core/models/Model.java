package com.discography.core.models;

public abstract class Model<T> implements IModel {
	protected String name;
	protected T value;
	
	public Model(String name, T value) {
		this.name = name;
		this.value = value;
	}
	
	public Model(String name) {
		this.name = name;
		this.value = null;
	}
	
	public Model() {
		name = null;
		value = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
