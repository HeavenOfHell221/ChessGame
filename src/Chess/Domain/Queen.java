package Chess.Domain;

public class Queen extends Piece
{

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isMovementLegal(Movement m) 
    {
        return isMovementDiagonal(m) || isMovementLinear(m);
    }

    private boolean isMovementDiagonal(Movement m)
    {
        int verticalDistance = CellLine.getAbsDistance(m.getOrigin().getLine(), m.getOrigin().getLine()); 
        int horizontalDistance = CellColumn.getAbsDistance(m.getOrigin().getColumn(), m.getOrigin().getColumn()); 
        return verticalDistance == horizontalDistance;
    }

    private boolean isMovementLinear(Movement m)
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
