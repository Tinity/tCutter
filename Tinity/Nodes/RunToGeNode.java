package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.map.Area;

public class RunToGeNode extends Node {

    private final Area GE_AREA = new Area(3157,3496,3172,3482);
    private final int NOTED_LOG = 1512;
    public RunToGeNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getBank().isOpen() && c.getInventory().contains(NOTED_LOG);
    }

    @Override
    public int execute() {
        c.log("Running to GE...");
        if (GE_AREA.contains(c.getLocalPlayer())) {
            return 1000;
        } else {
            c.getWalking().walk(GE_AREA.getRandomTile());
        }


        return 1000;
    }
}
