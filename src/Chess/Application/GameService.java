package Chess.Application;

import Chess.Domain.Game;
import Chess.Domain.GameFactory;
import Chess.Domain.GameRepositoryITF;
import Chess.Domain.Movement;

/* STATELESS */

public class GameService 
{
    private final GameRepositoryITF m_repo;
    private final CommandsToExecute m_cToExecute;
    private final LoadGameQuery m_query;
    private long m_id = 0;

    public GameService(GameRepositoryITF repo, CommandsToExecute cToExecute, LoadGameQuery query) 
    {
        m_repo = repo;
        m_cToExecute = cToExecute;
        m_query = query;
    }

    public long createNewGame() 
    {
        //long id = System.currentTimeMillis(); // ID
        long id = m_id++;
        Game g = new GameFactory().CreateNewGame(id); // New Game
        CommandITF c = new SaveGameCommand(m_repo, g); // Command
        m_cToExecute.push(c);
        return id;
    }

    public void moveAutoSave(long gameId, Movement m)
    {
        Game g = m_query.getGame(gameId); // Query

        if(g != null)
        {
            g.move(m);
            CommandITF c = new SaveGameCommand(m_repo, g); // Command
            m_cToExecute.push(c);
        }
    }
}
