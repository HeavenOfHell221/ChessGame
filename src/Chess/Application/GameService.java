package Chess.Application;

import Chess.Domain.Game;
import Chess.Domain.GameFactory;
import Chess.Domain.GameRepositoryITF;
import Chess.Domain.Movement;

/* CLASS STATELESS */

public class GameService 
{
    private final GameRepositoryITF m_repo;
    private final CommandsToExecute m_cToExecute;
    private final LoadGameQuery m_query;
    private long m_id = 0; // Utilisation d'une variable id car la boucle du Main crée plusieurs game dans la même milliseconde...

    public GameService(GameRepositoryITF repo, CommandsToExecute cToExecute) 
    {
        m_repo = repo;
        m_cToExecute = cToExecute;
        m_query = new LoadGameQuery(repo);
    }

    public long createNewGame() 
    {
        //long id = System.currentTimeMillis();
        long id = m_id++;
        Game g = new GameFactory().CreateNewGame(id); // New Game
        save_async(g);
        return id;
    }

    public void moveAutoSave(long gameId, Movement m)
    {
        Game g = m_query.loadGame(gameId); // Query

        if(g != null)
        {
            g.move(m);
            save_async(g); // Command
        }
    }
  
    public void move(long gameId, Movement m)
    {
        Game g = m_query.loadGame(gameId); // Query
        
        if(g != null)
        {
            g.move(m);
        }
    }

    private void save_async(Game g)
    {
        m_cToExecute.push(new SaveGameCommand(m_repo, g));
    }
}
