package com.discography.core.models;

public class ModelParsingException extends Exception {
	private static final String MSG = "Incorrect model type";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModelParsingException() {
		super(MSG);
	}

}
