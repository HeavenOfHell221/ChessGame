package Chess.Domain;

public interface GameRepositoryITF
{
    void save(Game g);
    Game load(int id);
}