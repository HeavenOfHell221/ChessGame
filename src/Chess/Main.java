package Chess;

import Chess.Application.CommandToExecute;
import Chess.Application.GameService;
import Chess.Application.ThreadCommand;
import Chess.Domain.Cell;
import Chess.Domain.CellColumn;
import Chess.Domain.CellLine;
import Chess.Domain.Movement;
import Chess.Infra.GameRepositoryInMemory;

public class Main 
{
    public static void main(String[] args) 
    {
        CommandToExecute commandToExecute = new CommandToExecute();
        GameService service = new GameService(new GameRepositoryInMemory(), commandToExecute);
        
        Thread threads[] = new Thread[6];

        for(int i = 0; i < threads.length; i++)
        {
            ThreadCommand threadCommand = new ThreadCommand(commandToExecute);
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
            service.move(ids[i], new Movement(Cell.newFactory(CellColumn.Column_a, CellLine.Line_2), Cell.newFactory(CellColumn.Column_a, CellLine.Line_3)));
        }
        
        
        commandToExecute.stopThreads();
    }    
}
