package Chess.Infra;

import java.util.HashSet;
import java.util.Set;

import Chess.Domain.Debug;
import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;

public class GameRepositoryInMemory implements GameRepositoryITF
{
    Set<Game> m_memory;

    public GameRepositoryInMemory()
    {
        m_memory = new HashSet<>();
    }

    public void save(Game game)
    {
        m_memory.add(game);
        Debug.log("Sauvegarde in memory.");
    }

    public Game load(long gameId)
    {
        for(Game g : m_memory)
        {
            if(g.getID() == gameId)
            {
                Debug.log("Load avec succès.");
                return g;
            }
        }
        return null;
    }
}