package Chess.Domain;

public class Queen extends Piece
{

    public Queen(PieceColors color) {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) {
        return false;
    }
    
}
