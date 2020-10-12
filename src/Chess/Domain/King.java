package Chess.Domain;

public class King extends Piece
{

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isMovementLegal(Movement m) 
    {
        int verticalDistance = CellLine.getAbsDistance(m.getOrigin().getLine(), m.getOrigin().getLine()); 
        int horizontalDistance = CellColumn.getAbsDistance(m.getOrigin().getColumn(), m.getOrigin().getColumn()); 

        int res = verticalDistance + horizontalDistance;

        return res != 0 && verticalDistance <= 1 && horizontalDistance <= 1;
    }

    @Override
    public boolean isPathClear(Movement m) 
    {
        return false;
    }
    
}
