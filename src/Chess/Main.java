package Chess;

import Chess.Domain.Cell;
import Chess.Domain.CellColumn;
import Chess.Domain.CellLine;
import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;
import Chess.Domain.Movement;
import Chess.Infra.GameRepositoryInMemory;

public class Main 
{
    public static void main(String[] args) 
    {
        Game g = new Game(42);
        g.move(new Movement(Cell.newFactory(CellColumn.Column_a, CellLine.Line_2), Cell.newFactory(CellColumn.Column_a, CellLine.Line_8)));
        
        GameRepositoryITF repository = new GameRepositoryInMemory();
        repository.save(g);
    }    
}
