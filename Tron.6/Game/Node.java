package Game;

public class Node {
    public Node Up, Down, Left, Right;
    public int Value;
    
    public Node() {
        Value = -1;
        Up = Down = Left = Right = null;
    }
}
