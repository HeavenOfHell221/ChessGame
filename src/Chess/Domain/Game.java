package Chess.Domain;

import java.util.ArrayDeque;

/* AGGREGATE */

public class Game 
{
    private final Chessboard m_chessboard;              
    private final long m_gameID;                        
    private final ArrayDeque<Movement> m_movements;   

    public Game(long gameID)
    {
        m_gameID = gameID;
        m_chessboard = new Chessboard(gameID);
        m_movements = new ArrayDeque<Movement>();
    }

    public Game(long gameID, Game initGame)
    {
        Debug.ASSERT(initGame != null, "Création d'un game failed.");
        m_gameID = gameID;
        m_chessboard = new Chessboard(gameID, initGame.m_chessboard);
        m_movements = new ArrayDeque<Movement>(initGame.m_movements);
    }

    public Game getCopy()
    {
        Game c = new Game(this.m_gameID, this);
        return c;
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
