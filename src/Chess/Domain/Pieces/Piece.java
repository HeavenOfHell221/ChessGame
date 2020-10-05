package Chess.Domain.Pieces;

import Chess.Domain.*;
import Chess.Domain.Enums.*;

/* VALUE OBJECT */

public abstract class Piece 
{
    private final PieceColors m_color;

    public Piece(PieceColors color)
    {
        m_color = color;
    }

    public abstract boolean canMove(Cell from, Cell to);

    public final PieceColors getColor()
    {
        return m_color;
    }
}
