package Chess.Application;

import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;

public class LoadGameQuery 
{
    private final GameRepositoryITF m_repo;
    private Game m_gameCache;

    public LoadGameQuery(GameRepositoryITF repo)
    {   
        m_repo = repo;
    }

    public Game getGame(long id)
    {
        if(m_gameCache == null || m_gameCache.getID() != id)
        {
            m_gameCache = m_repo.load(id);
        }

        return m_gameCache;
    }
}
