package Chess.Domain;

public class Pawn extends Piece
{
    public enum Direction
    {
        Up(1),
        Down(-1);

        private int m_value;

        private Direction(int value)
        {
            m_value = value;
        }

        public int getValue()
        {
            return m_value;
        }
    }

    private final Direction m_direction;

    public Pawn(Color color)
    {
        super(color);
        m_direction = (this.getColor() == Color.White) ? Direction.Up : Direction.Down;
    }

    @Override
    public boolean isMovementLegal(Movement m, LocationOfPiecesITF board) 
    {
        return normalMove(m.getOrigin(), m.getDestination()) || captureMove(m.getOrigin(), m.getDestination(), board);
    }

    private boolean normalMove(Cell from, Cell to)
    {
        boolean isMoveValid = false;

        if(to.getColumn() == from.getColumn())
        {
            int nbCell = (isPawnAtStartPosition(from) && CellLine.getAbsDistance(from.getLine(), to.getLine()) == 2) ? 2 : 1;

            if(to.getLine().getValue() == (from.getLine().getValue() + nbCell * m_direction.getValue()))
            {
                isMoveValid = true;
            }
        }

        return isMoveValid;
    }

    private boolean isPawnAtStartPosition(Cell from)
    {
        return (from.getLine() == CellLine.Line_2 && getColor() == Color.White)
            || (from.getLine() == CellLine.Line_7 && getColor() == Color.Black);
    }

    private boolean captureMove(Cell from, Cell to, LocationOfPiecesITF board)
    {
        boolean isMoveValid = false;
        Cell c = Cell.newFactory(from.getColumn(), to.getLine());

        if(board.isTherePieceAt(c) && to.getLine().getValue() == (from.getLine().getValue() + m_direction.getValue())
        && CellColumn.getAbsDistance(from.getColumn(), to.getColumn()) == 1)
        {
            isMoveValid = true;
        }

        return isMoveValid;
    }

    @Override
    public boolean isPathClear(Movement m) 
    {
        return false;
    }
}
