package Chess.Domain;

import java.util.ArrayDeque;
import Chess.Domain.Utils.*;

/* AGGREGATE */

public class Game 
{
    private final Chessboard m_chessboard;              // Le plateau de jeu contenant les pièces et les cases
    private final int m_gameID;                         // L'ID unique de cette partie
    private final ArrayDeque<Movement> m_movements;     // File des mouvements effectué lors de la partie

    public Game()
    {
        m_chessboard = new Chessboard(null);
        m_movements = new ArrayDeque<Movement>();
        m_gameID = 0;
    }

    // Effectue un mouvement sur le plateau s'il est valide
    // et l'ajoute (le mouvement) dans la pile des mouvements déjà effectué
    public void move(Movement m)
    {
        Debug.ASSERT(m != null && m.getOrigin() != null && m.getDestination() != null, 
        "Un mouvement est null ou présente une/des case(s) null dans la méthode move(Movement m) de la classe Game !");

        if(!m_chessboard.movementIsValid(m)) // Si le mouvement n'est pas valide, on effectue rien
        {
            Debug.log("Un mouvement non valide a été tenté");
            return;
        }

        m_movements.addLast(m);
        m_chessboard.processMovement(m);
    }

    // Annule le dernier mouvement effectué (s'il y en a un)
    public void undoLastMove()
    {
        Movement movementToCancel = m_movements.pollLast();
        if(movementToCancel != null)
            m_chessboard.cancelMovement(movementToCancel);
    }
}
