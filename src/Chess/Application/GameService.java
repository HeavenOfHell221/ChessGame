package Chess.Application;

import Chess.Domain.Debug;
import Chess.Domain.Game;
import Chess.Domain.GameFactory;
import Chess.Domain.GameRepositoryITF;
import Chess.Domain.Movement;

public class GameService 
{
    private Game m_cache;
    private final GameRepositoryITF m_repo;

    public GameService(GameRepositoryITF repo) 
    {
        m_repo = repo;
    }

    public long createNewGame() {
        long id = System.currentTimeMillis();
        GameFactory gFactory = new GameFactory();
        m_cache = gFactory.gameFactory(id);
        m_repo.save(m_cache);

        return id;
    }

    public void move(long gameId, Movement m)
    {
        Debug.ASSERT(m_cache != null, "On essai de faire un mouvement sur une partie non créée.");
        
        if(m_cache.getID() != gameId)
            m_cache = m_repo.load(gameId);

        m_cache.move(m);
        m_repo.save(m_cache);
    }
}
