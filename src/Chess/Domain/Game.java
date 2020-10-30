package Chess.Domain;

import java.util.ArrayDeque;

/* AGGREGATE */

public class Game 
{
    private final Chessboard m_chessboard;              
    private final long m_gameID;                        
    private final ArrayDeque<Movement> m_movements;   

    public Game(long gameId)
    {
        m_chessboard = new Chessboard(null, gameId);
        m_movements = new ArrayDeque<Movement>();
        m_gameID = gameId;
    }

    public void move(Movement m)
    {
        Debug.ASSERT(m != null, 
        "Un mouvement est null dans la méthode move(Movement m) de la classe Game !");

        if(m_chessboard.isMovementValid(m))
        {
            m_movements.addLast(m);
            m_chessboard.processMovement(m);
        }
        else
        {
            Debug.logError("Un mouvement non valide a été tenté");
        }
    }

    public void undoLastMove()
    {
        Movement movementToCancel = m_movements.pollLast();
        if(movementToCancel != null)
            m_chessboard.cancelMovement(movementToCancel);
    }

    public long getID()
    {
        return m_gameID;
    }
}
