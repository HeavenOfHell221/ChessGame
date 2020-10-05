package Chess.Domain;

public class Knight extends Piece
{

    public Knight(Color color) 
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return false;
    }
    
}
