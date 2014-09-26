package com.jliang3.todo;

public class TextEditorController {
	private static TextEditorList texteditorList = null;
	static public TextEditorList getTextEditorList(){
		if (texteditorList == null){
			texteditorList = new TextEditorList();
		}
		return texteditorList;	
	}
	public TextEditor chooseTextEditor() throws EmptyTextEditorListException{
		return getTextEditorList().chooseTextEditor();
	}
}
