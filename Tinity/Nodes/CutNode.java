package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.map.Area;


public class CutNode extends Node {
    private static final Area TREE_AREA = new Area(3116, 3444, 3141, 3419);
    private static final int TREE = 1278;

    public CutNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return TREE_AREA.contains(c.getLocalPlayer()) && !c.getLocalPlayer().isAnimating() && !c.getLocalPlayer().isMoving();
    }

    @Override
    public int execute() {
        c.log("Cutting...");
        c.getGameObjects().closest(TREE).interact("Chop down");


        return 1000;
    }


}
