package Chess.Domain;

public class Bishop extends Piece
{
    public Bishop(Color color) 
    {
        super(color);
    }

    @Override
    public boolean isMovementLegal(Movement m) 
    {
        int verticalDistance = CellLine.getAbsDistance(m.getOrigin().getLine(), m.getOrigin().getLine()); 
        int horizontalDistance = CellColumn.getAbsDistance(m.getOrigin().getColumn(), m.getOrigin().getColumn()); 
        return verticalDistance == horizontalDistance;
    }

    @Override
    public boolean isPathClear(Movement m) 
    {
        return false;
    }
}
