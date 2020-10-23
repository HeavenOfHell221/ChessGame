package Chess.Application;

import Chess.Domain.Game;
import Chess.Domain.GameFactory;
import Chess.Domain.GameRepositoryITF;
import Chess.Domain.Movement;

public class GameService 
{
    private final GameRepositoryITF m_repo;
    private final CommandToExecute m_cToExecute;
    private long m_id = 0;

    public GameService(GameRepositoryITF repo, CommandToExecute cToExecute) 
    {
        m_repo = repo;
        m_cToExecute = cToExecute;
    }

    public long createNewGame() 
    {
        //long id = System.currentTimeMillis(); // ID
        long id = m_id++;
        Game g = new GameFactory().gameFactory(id); // New Game
        CommandITF c = new SaveGameCommand(m_repo, g); // Command
        m_cToExecute.addCommand(c);
        return id;
    }

    public void move(long gameId, Movement m)
    {
        Game g = m_repo.load(gameId);
        if(g != null)
        {
            g.move(m);
            CommandITF c = new SaveGameCommand(m_repo, g); // Command
            m_cToExecute.addCommand(c);
        }
    }
}
