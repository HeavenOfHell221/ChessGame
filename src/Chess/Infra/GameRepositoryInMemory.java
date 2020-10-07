package Chess.Infra;

import java.util.HashSet;
import java.util.Set;
import Chess.Domain.Game;
import Chess.Domain.IGameRepository;

public class GameRepositoryInMemory implements IGameRepository
{
    Set<Game> m_memory;

    public GameRepositoryInMemory()
    {
        m_memory = new HashSet<>();
    }

    public void save(Game game)
    {
        m_memory.add(game);
    }

    public Game load(int gameId)
    {
        for(Game g : m_memory)
        {
            if(g.getID() == gameId)
            {
                return g;
            }
        }
        return null;
    }
}