package Chess.Domain;

public class Bishop extends Piece
{
    public Bishop(PieceColors color) 
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return false;
    }    
}
