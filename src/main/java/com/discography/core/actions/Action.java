package com.discography.core.actions;

public abstract class Action {
	public abstract void start();
	public abstract void undo();
	public abstract void redo();
}
