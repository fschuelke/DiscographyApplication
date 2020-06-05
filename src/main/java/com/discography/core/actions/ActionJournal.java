package com.discography.core.actions;

import java.util.Stack;

public class ActionJournal {
	private final Stack<Action> undoActions, redoActions;
	
	public ActionJournal() {
		undoActions = new Stack<>();
		redoActions = new Stack<>();
	}
	
	public void onUndo() {
		Action action = undoActions.pop();
		action.undo();
		redoActions.push(action);
	}
	
	public void onRedo() {
		Action action = redoActions.pop();
		action.redo();
		undoActions.push(action);
	}
	
	public void journalAction(Action action) {
		action.start();
		undoActions.push(action);
	}

}
