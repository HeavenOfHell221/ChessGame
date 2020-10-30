package Chess.Application;

import java.util.HashMap;

import Chess.Domain.Debug;
import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;

/* Stateless dans le sens où on peut le supprimer sans rien perdre */
/* Le cache n'est pas considéré comme une information perdue, il est seulement là pour un gain de temps */

public class LoadGameQuery 
{
    private final GameRepositoryITF m_repo;
    private final HashMap<Long, Game> m_gamesCache;

    public LoadGameQuery(GameRepositoryITF repo)
    {   
        m_repo = repo;
        m_gamesCache = new HashMap<>();
    }

    public Game loadGame(long id)
    {
        Game gameToReturn = null;

        if(!m_gamesCache.containsKey(id)) // Si le game n'est pas dans le cache
        {
            gameToReturn = m_repo.load(id);
            Debug.ASSERT(gameToReturn != null, "le load à partir du repository du jeu ID = " + id + " a échoué.");
            m_gamesCache.put(id, gameToReturn); 
        }
        else
            gameToReturn = m_gamesCache.get(id); // On le load via le cache

        return gameToReturn;
    }
}
