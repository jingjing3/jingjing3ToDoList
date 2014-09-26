package com.jliang3.todo;

import java.util.ArrayList;
import java.util.Collection;

public class TextEditorList {
	protected ArrayList<TextEditor>texteditorList;
	public TextEditorList(){
		texteditorList = new ArrayList<TextEditor>();
		
	}
	public Collection<TextEditor> getTextEditors() {
		// TODO Auto-generated method stub
		return texteditorList;
	}
	public void addTextEditor(TextEditor testTextEditor){
		texteditorList.add(testTextEditor);
	}
	public void removeTextEditor(TextEditor testTextEditor) {
		texteditorList.remove(testTextEditor);
		
	}
	public TextEditor chooseTextEditor() throws EmptyTextEditorListException{
		int size = texteditorList.size();
		if (size<=0){
			throw new EmptyTextEditorListException();
		}
		int index = (int) (texteditorList.size() * Math.random());
		
		return texteditorList.get(index);
		
	}
	public int size(){
		
		return texteditorList.size();
	}
	public boolean contains (TextEditor testTextEditor){
		return texteditorList.contains(testTextEditor);
	}
}
