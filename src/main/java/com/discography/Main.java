package com.discography;

import com.discography.core.Settings;
import com.discography.core.actions.ActionJournal;

public class Main {
	public static boolean DEBUG;
	
	private static Main instance;
	
	public static Main instance() {
		if(instance == null)
			instance = new Main();
		return instance;
	}
	
	private Settings settings;
	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	private final ActionJournal actionJournal;
	
	public static Main getInstance() {
		return instance;
	}

	public static void setInstance(Main instance) {
		Main.instance = instance;
	}

	private Main() {
		actionJournal = new ActionJournal();
		settings = new Settings();
	}
	
	/**
	 * load paths written by installation
	 * @throws Exception 
	 */
	private void init() throws Exception {
		//settings.load(null);
	}
	
	private void start() throws Exception {
	}
	
	private void stop() throws Exception {
	}
	
	private void destroy() {}
	
	private void processArgs(String[] args) {
		if(System.getProperties().containsKey("Debug")) {
			DEBUG = Boolean.parseBoolean(System.getProperty("Debug"));
		}
	}
	
	public void launch(String[] args) throws Exception {
		processArgs(args);
		init();
		start();
	}
	
	public ActionJournal getActionJournal() {
		return actionJournal;
	}
	
	public static void main(String[] args) {
		try {
			instance().launch(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onExit() throws Exception {
		stop();
		destroy();
	}
}
