package Chess.Domain;

public class Knight extends Piece
{

    public Knight(PieceColors color) 
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return false;
    }
    
}
