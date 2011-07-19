package ita23.projekt.mud;

import java.util.ArrayList;

public class CommandStack {
	
	private ArrayList<String> stack;
	private int position;
	
	public CommandStack(){
		stack = new ArrayList<String>();
		position = 0;
	}
	
	public String getNext(){
		if (stack.size() == 0){
			return "";
		}
		if (position > (stack.size() -1) ){
			position = stack.size();
			return "";
		}
		position++;
		return stack.get(position);
	}
	
	public String getPrevous(){
		if (stack.size() == 0){
			return "";
		}
		if (position < 0){
			position = 0;
			return stack.get( 0 );
		}
		position--;
		return stack.get(position);
	}
	
	public void add(String s){
		stack.add(s);
		position = stack.size();
	}

}
