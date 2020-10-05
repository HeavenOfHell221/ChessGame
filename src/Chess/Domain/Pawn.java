package Chess.Domain;

public class Pawn extends Piece
{
    public Pawn(Color color)
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return true;
    }
}
