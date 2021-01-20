package strategies;

import game.producer.Producer;

import java.util.List;

public interface Strategy {
     Producer chooseStrategy( List<Producer> producers);

}
