package Chess.Domain;

public class King extends Piece
{

    public King(PieceColors color) {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) {
        return false;
    }
    
}
