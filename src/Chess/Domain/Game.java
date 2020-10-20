package Chess.Domain;

import java.util.ArrayDeque;

/* AGGREGATE */

public class Game 
{
    private final Chessboard m_chessboard;              // Le plateau de jeu contenant les pièces et les cases
    private final long m_gameID;                         // L'ID unique de cette partie
    private final ArrayDeque<Movement> m_movements;     // File des mouvements effectué lors de la partie

    public Game(long gameId)
    {
        m_chessboard = new Chessboard(null, gameId);
        m_movements = new ArrayDeque<Movement>();
        m_gameID = gameId;
    }

    // Effectue un mouvement sur le plateau s'il est valide
    // et l'ajoute (le mouvement) dans la pile des mouvements déjà effectué
    public void move(Movement m)
    {
        Debug.ASSERT(m != null && m.getOrigin() != null && m.getDestination() != null, 
        "Un mouvement est null ou présente une/des case(s) null dans la méthode move(Movement m) de la classe Game !");

        if(m_chessboard.isMovementValid(m)) // Si le mouvement n'est pas valide, on effectue rien
        {
            m_movements.addLast(m);
            m_chessboard.processMovement(m);
        }
        else
        {
            Debug.logError("Un mouvement non valide a été tenté");
        }
    }

    // Annule le dernier mouvement effectué (s'il y en a un)
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
