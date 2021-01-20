package game.Distributor;

import game.producer.Producer;

import java.util.List;

public interface Observer {
    void update(List<Producer> producers);
}
