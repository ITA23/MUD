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
		position++;
		if (position > stack.size()){
			position--;
			return stack.get( stack.size() );
		}
		return stack.get(position);
	}
	
	public String getPrevous(){
		position--;
		if (position < 0){
			position++;
			return stack.get( 0 );
		}
		return stack.get(position);
	}
	
	public void add(String s){
		stack.add(s);
		position = 0;
	}

}
