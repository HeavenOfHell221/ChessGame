package Chess.Domain;

public class Pawn extends Piece
{
    public Pawn(PieceColors color)
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return true;
    }
}
