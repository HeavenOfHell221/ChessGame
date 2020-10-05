package Chess.Domain;

import Chess.Domain.Enums.*;
import Chess.Domain.Utils.*;

/* VALUE OBJECT */

public class Cell
{
    private final CellLine m_line;
    private final CellColumn m_column;
    private final PieceColors m_cellColor;
    private final String m_id;

    public static Cell newFactory(CellColumn column, CellLine line, PieceColors color)
    {
        Debug.ASSERT(line != null && column != null && color != null, "Un attribut de la classe Case est null.");
        return new Cell(column, line, color);
    }

    private Cell(CellColumn column, CellLine line, PieceColors color) 
    {
        m_line = line;
        m_column = column;
        m_cellColor = color;
        m_id = "" + column.string() + line.string();
    }

    public CellLine getLine() 
    {
        return m_line;
    }

    public CellColumn getColumn() 
    {
        return m_column;
    }

    public PieceColors getColor() 
    {
        return m_cellColor;
    }

    @Override
    public int hashCode() 
    {
		return m_id.hashCode();
	}

	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell))
            return false;
        Cell other = (Cell) obj;
        return (m_column == other.m_column) && (m_line == other.m_line);
    }
}