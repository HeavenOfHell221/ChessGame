package Chess.Domain;

public interface IGameRepository
{
    void save(Game g);
    Game load(int id);
}