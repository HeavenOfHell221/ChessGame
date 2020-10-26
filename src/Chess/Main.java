package Chess;

import Chess.Application.CommandsToExecute;
import Chess.Application.GameService;
import Chess.Application.LoadGameQuery;
import Chess.Application.ThreadCommand;
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
        CommandsToExecute commandsToExecute = new CommandsToExecute();
        GameRepositoryITF gameRepository = new GameRepositoryInMemory();
        LoadGameQuery loadGameQuery = new LoadGameQuery(gameRepository);
        GameService service = new GameService(gameRepository, commandsToExecute, loadGameQuery);
        
        Thread threads[] = new Thread[6];

        for(int i = 0; i < threads.length; i++)
        {
            ThreadCommand threadCommand = new ThreadCommand(commandsToExecute);
            threads[i] = new Thread(threadCommand, "threadCommand " + i);
            threads[i].setDaemon(false);
            threads[i].start();
        }

        long ids[] = new long[10];

        for(int i = 0; i < ids.length; i++)
        {
            ids[i] = service.createNewGame();
        }
        
        for(int i = 0; i < ids.length; i++)
        {
            service.moveAutoSave(ids[i], new Movement(Cell.newFactory(CellColumn.Column_a, CellLine.Line_2), Cell.newFactory(CellColumn.Column_a, CellLine.Line_3)));
        }
    }    
}
