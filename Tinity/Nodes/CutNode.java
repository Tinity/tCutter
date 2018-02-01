package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.skills.Skill;


public class CutNode extends Node {
    private static final Area TREE_AREA = new Area(3116, 3444, 3141, 3419);
    private static final Area OAK_AREA = new Area(3123,3443,3136,3429);
    private static final int TREE = 1278;
    private static final int OAK = 1751;

    public CutNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return TREE_AREA.contains(c.getLocalPlayer()) && !c.getLocalPlayer().isAnimating() && !c.getLocalPlayer().isMoving();
    }

    @Override
    public int execute() {

        if (c.getSkills().getRealLevel(Skill.WOODCUTTING) >= 15) {
            c.log("Cutting Oak...");
            c.getGameObjects().closest(OAK).interact("Chop down");
        } else {
            c.log("Cutting Tree...");
            c.getGameObjects().closest(TREE).interact("Chop down");
        }



        return 1000;
    }


}
