package Chess.Domain;

public class Rook extends Piece
{
    public Rook(Color color) 
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return false;
    }
}
