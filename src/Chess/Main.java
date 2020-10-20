package Chess;

import Chess.Application.GameService;
import Chess.Domain.Cell;
import Chess.Domain.CellColumn;
import Chess.Domain.CellLine;
import Chess.Domain.GameRepositoryITF;
import Chess.Domain.Movement;
import Chess.Infra.GameRepositoryInMemory;

public class Main 
{
    public static void main(String[] args) 
    {
        GameRepositoryITF repo = new GameRepositoryInMemory();
        GameService service = new GameService(repo);
        long id = service.createNewGame();
        Movement m = new Movement(Cell.newFactory(CellColumn.Column_a, CellLine.Line_1), Cell.newFactory(CellColumn.Column_a, CellLine.Line_3));
        service.move(id, m);
    
    }    
}
