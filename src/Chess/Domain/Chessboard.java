package Chess.Domain;

import java.util.ArrayDeque;
import java.util.HashMap;

import static Chess.Domain.CellColumn.*;
import static Chess.Domain.CellLine.*;
import static Chess.Domain.Color.*;

/* ENTITY */

public class Chessboard implements LocationOfPiecesITF
{
    private final HashMap<Cell, Piece> m_piecesOnBoard;         // HashMap des pièces actuellement sur le plateau
    private final HashMap<Movement, ArrayDeque<Piece>> m_piecesCaptured;   // HashMap des pièces "mortes"
    private final long m_chessboardID;


    public Chessboard(long chessboardID)
    {
        m_chessboardID = chessboardID;

        CellsInitialization();

        m_piecesOnBoard = new HashMap<>();
        m_piecesCaptured = new HashMap<>();

        PiecesInitialization();
    }

    public Chessboard(long chessboardID, Chessboard initialChess)
    {
        Debug.ASSERT(initialChess != null, "Création d'un chessboard failed.");
        
        m_chessboardID = chessboardID;
        
        CellsInitialization();

        m_piecesOnBoard = new HashMap<>(initialChess.m_piecesOnBoard);
        m_piecesCaptured = new HashMap<>(initialChess.m_piecesCaptured);
    }

    

    // Création des cases du plateau de jeu
    private void CellsInitialization()
    {
        for(CellColumn column : CellColumn.values())
        {
            for(CellLine line : CellLine.values())
            {
                m_piecesOnBoard.put(Cell.newFactory(column, line), null);
            }
        }
    }

    // Création des différentes pièces
    // Placement des pièces sur leur emplacement de base
    private void PiecesInitialization()
    {
        for(CellColumn column : CellColumn.values())
        {
            addNewPiece(new Pawn(White), column, Line_2);
            addNewPiece(new Pawn(Black), column, Line_7);
        }

        addNewPiece(new Rook(White), Column_a, Line_1);
        addNewPiece(new Rook(White), Column_h, Line_1);
        addNewPiece(new Rook(Black), Column_a, Line_8);
        addNewPiece(new Rook(Black), Column_h, Line_8);
        addNewPiece(new Knight(White), Column_b, Line_1);
        addNewPiece(new Knight(White), Column_g, Line_1);
        addNewPiece(new Knight(Black), Column_b, Line_8);
        addNewPiece(new Knight(Black), Column_g, Line_8);
        addNewPiece(new Bishop(White), Column_c, Line_1);
        addNewPiece(new Bishop(White), Column_f, Line_1);
        addNewPiece(new Bishop(Black), Column_c, Line_8);
        addNewPiece(new Bishop(Black), Column_f, Line_8);
        addNewPiece(new Queen(White), Column_d, Line_1);
        addNewPiece(new Queen(Black), Column_d, Line_8);
        addNewPiece(new King(White), Column_e, Line_1);
        addNewPiece(new King(Black), Column_e, Line_8);
    }

    private void addNewPiece(Piece value, CellColumn column, CellLine line)
    {
        Cell key = Cell.newFactory(column, line);

        Debug.ASSERT(m_piecesOnBoard.get(key) == null, "Ajout d'une nouvelle pièce dans une case en contenant déjà une.");

        m_piecesOnBoard.replace(key, value);
    }

    public boolean isMovementValid(Movement m)
    {
        Piece p = getPieceAt(m.getOrigin());
        Debug.ASSERT(p != null, "On essai d'effectuer un mouvement avec une pièce null sur la cellule " + m.getOrigin().toString());

        return p.isMovementLegal(m, this);
    }

    public void processMovement(Movement m)
    {
        Piece p = getPieceAt(m.getOrigin());
        Piece p2 = getPieceAt(m.getDestination());

        if(p2 != null) // Si il y a une pièce sur la case "destination"
        {
            Debug.log("Un pièce " + p.getClass() + " a été capturée");
            pieceCapture(m, p2);
        }

        placePieceOnCell(null, m.getOrigin());
        placePieceOnCell(p, m.getDestination());

        Debug.log("Piece moved successfully!");
    }

    private void pieceCapture(Movement m, Piece p)
    {
        if(m_piecesCaptured.containsKey(m))
        {
            m_piecesCaptured.get(m).addLast(p);
        }
        else
        {
            ArrayDeque<Piece> queue = new ArrayDeque<Piece>();
            queue.addLast(p); 
            m_piecesCaptured.put(m, queue);
        }
    }

    public void cancelMovement(Movement m)
    {
        Piece p = getPieceAt(m.getDestination());
        Piece p2 = null;

        if(m_piecesCaptured.containsKey(m))
        {
            p2 = m_piecesCaptured.get(m).pollLast();
        }

        placePieceOnCell(p, m.getOrigin());
        placePieceOnCell(p2, m.getDestination());
    }

    private void placePieceOnCell(Piece piece, Cell cell)
    {
        m_piecesOnBoard.replace(cell, piece);
    }

    private Piece getPieceAt(Cell cell)
    {
        return m_piecesOnBoard.get(cell);
    }

    public long getchessboardID()
    {
        return m_chessboardID;
    }

    @Override
    public boolean isTherePieceAt(Cell cell) 
    {
        return m_piecesOnBoard.get(cell) != null;
    }
}