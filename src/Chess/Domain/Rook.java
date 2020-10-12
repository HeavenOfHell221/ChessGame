package Chess.Domain;

public class Rook extends Piece
{
    public Rook(Color color) 
    {
        super(color);
    }

    @Override
    public boolean isMovementLegal(Movement m, LocationOfPiecesITF board) 
    {
        boolean isMoveHorizontal = (CellLine.getAbsDistance(m.getOrigin().getLine(), m.getOrigin().getLine()) == 0) 
                                && (CellColumn.getAbsDistance(m.getOrigin().getColumn(), m.getOrigin().getColumn()) != 0);
        boolean isMoveVertical = (CellLine.getAbsDistance(m.getOrigin().getLine(), m.getOrigin().getLine()) != 0) 
                                && (CellColumn.getAbsDistance(m.getOrigin().getColumn(), m.getOrigin().getColumn()) == 0);
                                
        return isMoveHorizontal ^ isMoveVertical;
    }

    @Override
    public boolean isPathClear(Movement m) 
    {
        return false;
    }
}
