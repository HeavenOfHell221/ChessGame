package Chess.Domain;

public class Knight extends Piece
{

    public Knight(Color color) 
    {
        super(color);
    }
    
    @Override
    public boolean isMovementLegal(Movement m, LocationOfPiecesITF board) 
    {
        int verticalDistance = CellLine.getAbsDistance(m.getOrigin().getLine(), m.getOrigin().getLine()); 
        int horizontalDistance = CellColumn.getAbsDistance(m.getOrigin().getColumn(), m.getOrigin().getColumn()); 
        return (verticalDistance == 1 && horizontalDistance == 2) || (verticalDistance == 2 && horizontalDistance == 1);
    }

    @Override
    public boolean isPathClear(Movement m) 
    {
        return true;
    }
    
}
