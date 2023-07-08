package Memento;

public class Editor {
    private String content;
    public Editor(String content){
        this.content = content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public EditorState createState(){
        return new EditorState(this.content);
    }
    public void restore(EditorState state){
        this.content = state.getContent();
    }
    public static void main(String []args){
        Editor editor = new Editor("a");
        History history = new History();
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        // first undo
        editor.restore(history.pop());
        System.out.println(editor.getContent());
        // second undo
        editor.restore(history.pop());
        System.out.println(editor.getContent());

    }
}
