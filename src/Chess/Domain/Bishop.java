package Chess.Domain;

public class Bishop extends Piece
{
    public Bishop(Color color) 
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return false;
    }    
}
