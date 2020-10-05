package Chess.Domain.Pieces;

import Chess.Domain.*;
import Chess.Domain.Enums.*;

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