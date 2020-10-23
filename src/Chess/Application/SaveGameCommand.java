package Chess.Application;

import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;

public class SaveGameCommand implements CommandITF
{
    private final GameRepositoryITF m_repository;
    private final Game m_game;
    
    public SaveGameCommand(GameRepositoryITF repository, Game game)
    {
        m_repository = repository;
        m_game = game;
    }    

    public void exec()
    {
        m_repository.save(m_game);
    }
}
