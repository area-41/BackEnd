package br.ada.americanas.moviebattle.player;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
@Service
@Validated
public class PlayerService {

    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Player add(@Valid Player player) {
        return this.repository.save(player);
    }

    public Player update(@Valid Player player) {
        return this.repository.save(player);
    }

//    usar lista no lugar de iterable
    public Iterable<Player> list() {
        return this.repository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return this.repository.findById(id);
    }

    public Optional<Player> delete(Long id) {
        Optional<Player> deleted = findById(id);
        this.repository.deleteById(id);
        return deleted;
    }
}
