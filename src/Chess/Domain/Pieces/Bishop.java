package Chess.Domain.Pieces;

import Chess.Domain.*;
import Chess.Domain.Enums.*;

public class Bishop extends Piece
{
    public Bishop(PieceColors color) 
    {
        super(color);
    }

    @Override
    public boolean canMove(Cell from, Cell to) 
    {
        return false;
    }    
}
