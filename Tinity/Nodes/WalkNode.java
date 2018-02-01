package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.map.Area;

public class WalkNode extends Node {
    private static final Area TREE_AREA = new Area(3132, 3451, 3119, 3428);

    public WalkNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !TREE_AREA.contains(c.getLocalPlayer()) && !c.getLocalPlayer().isAnimating() && c.getInventory().onlyContains(item -> item != null && item.getName().contains(" axe"));
    }

    @Override
    public int execute() {
        c.log("Walking...");
        c.getWalking().walk(TREE_AREA.getRandomTile());
        return 1000;
    }
}
