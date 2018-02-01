package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.map.Area;

public class GoBackNode extends Node {
    private static final Area TREE_AREA = new Area(3116, 3444, 3141, 3419);
    private final int LOG = 1511;
    public GoBackNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !c.getInventory().isFull() && !TREE_AREA.contains(c.getLocalPlayer()) && c.getInventory().contains(LOG) && !c.getLocalPlayer().isMoving() && !c.getLocalPlayer().isAnimating();
    }

    @Override
    public int execute() {
        c.log("Moving back to tree area...");
        c.getWalking().walk(TREE_AREA.getRandomTile());
        return 1000;
    }
}
