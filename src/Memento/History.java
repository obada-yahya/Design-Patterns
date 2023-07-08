package Memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<EditorState>();

    public void push(EditorState state){
        this.states.add(state);
    }
    public EditorState pop(){
        if(states.size() == 0){
            System.out.println("There's no previous states ");
            return null;
        }
        EditorState curr = states.get(states.size() - 1);
        states.remove(states.size() - 1);
        return curr;
    }

}
