package Chess.Domain;

import java.util.HashMap;
import Chess.Domain.Enums.*;
import Chess.Domain.Pieces.*;
import Chess.Domain.Utils.*;
import static Chess.Domain.Enums.CellColumn.*;
import static Chess.Domain.Enums.CellLine.*;
import static Chess.Domain.Enums.PieceColors.*;

/* ENTITY */

public class Chessboard
{
    private final HashMap<Cell, Piece> m_piecesOnBoard;         // HashMap des pièces actuellement sur le plateau
    //private final Cell[][] m_cells;                             // Les cases du plateau
    private final HashMap<Movement, Piece> m_piecesCaptured;    // HashMap des pièces "mortes"

    public Chessboard(Chessboard initialChess)
    {
        //m_cells = new Cell[8][8];
        initializationOfCases();

        if(initialChess == null)
        {
            Debug.log("Nouvelle partie.");
            m_piecesOnBoard = new HashMap<>();
            m_piecesCaptured = new HashMap<>();
            initializationOfPieces();
        }
        else
        {
            Debug.log("Load d'une partie déjà commencé.");
            m_piecesOnBoard = new HashMap<>(initialChess.m_piecesOnBoard);
            m_piecesCaptured = new HashMap<>(initialChess.m_piecesCaptured);
        }
    }

    // Création des cases du plateau de jeu
    private void initializationOfCases()
    {
        PieceColors color = Black;
        
        for(CellColumn column : CellColumn.values())
        {
            for(CellLine line : CellLine.values())
            {
                m_piecesOnBoard.put(Cell.newFactory(column, line, color), null);
                color = color.opposite();
            }

            color = color.opposite();
        }
    }

    // Création des différentes pièces
    // Placement des pièces sur leur emplacement de base
    private void initializationOfPieces()
    {
        for(CellColumn column : CellColumn.values())
        {
            addNewPiece(new Pawn(White), column, Line_2, White);
            addNewPiece(new Pawn(Black), column, Line_7, Black);
        }

        addNewPiece(new Rook(White), Column_a, Line_1, White);
        addNewPiece(new Rook(White), Column_h, Line_1, White);
        addNewPiece(new Rook(Black), Column_a, Line_8, Black);
        addNewPiece(new Rook(Black), Column_h, Line_8, Black);
        addNewPiece(new Knight(White), Column_b, Line_1, White);
        addNewPiece(new Knight(White), Column_g, Line_1, White);
        addNewPiece(new Knight(Black), Column_b, Line_8, Black);
        addNewPiece(new Knight(Black), Column_g, Line_8, Black);
        addNewPiece(new Bishop(White), Column_c, Line_1, White);
        addNewPiece(new Bishop(White), Column_f, Line_1, White);
        addNewPiece(new Bishop(Black), Column_c, Line_8, Black);
        addNewPiece(new Bishop(Black), Column_f, Line_8, Black);
        addNewPiece(new Queen(White), Column_d, Line_1, White);
        addNewPiece(new Queen(Black), Column_d, Line_8, Black);
        addNewPiece(new King(White), Column_e, Line_1, White);
        addNewPiece(new King(Black), Column_e, Line_8, Black);
    }

    private void addNewPiece(Piece value, CellColumn column, CellLine line, PieceColors color)
    {
        Cell key = Cell.newFactory(column, line, color);

        Debug.ASSERT(!m_piecesOnBoard.containsKey(key), "Ajout d'une nouvelle pièce dans une case en contenant déjà une.");

        m_piecesOnBoard.replace(key, value);
    }

    public boolean movementIsValid(Movement m)
    {
        Piece p = getPieceAt(m.getOrigin());
        Debug.ASSERT(p != null, "On essai d'effectuer un mouvement avec une pièce null !");

        /*
        
            1/ Tester si le mouvement pour la pièce p existe (chaque pièce bouge d'une façon très stricte)
            2/ Tester s'il est possible
                2.1/ Mouvement pas en dehors du plateau
                2.2/ Ne met pas en danger notre propre King
                2.3/ Pion -> Il y a bien une pièce à capturé s'il essaie d'aller en diagonal 
                etc.
        
        */

        return true;
    }

    public void processMovement(Movement m)
    {
        Piece p = getPieceAt(m.getOrigin());
        Piece p2 = getPieceAt(m.getDestination());

        if(p2 != null) // Si il y a une pièce sur la case "destination"
        {
            m_piecesCaptured.put(m, p2); // La pièce "p2" est capturé
        }

        placePieceOnCase(null, m.getOrigin());
        placePieceOnCase(p, m.getDestination());

        Debug.log("Successfully moved piece !");
    }

    public void cancelMovement(Movement m)
    {
        Piece p = getPieceAt(m.getDestination());
        Piece p2 = null;

        if(m_piecesCaptured.containsKey(m))
        {
            p2 = m_piecesCaptured.get(m);
            m_piecesCaptured.remove(m);
        }

        placePieceOnCase(p, m.getOrigin());
        placePieceOnCase(p2, m.getDestination());
    }

    private void placePieceOnCase(Piece piece, Cell cell)
    {
        m_piecesOnBoard.replace(cell, piece);
    }

    private Piece getPieceAt(Cell cell)
    {
        return m_piecesOnBoard.get(cell);
    }
}