package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.skills.Skill;

public class SellingNode extends Node {

    private final Area GE_AREA = new Area(3157,3496,3172,3482);
    private final int NOTED_LOG = 1512;
    private final int COINS = 995;
    private final int BLACK_AXE = 1361;
    private int GET_AXE;

    public SellingNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return GE_AREA.contains(c.getLocalPlayer()) && c.getInventory().contains(NOTED_LOG);
    }

    @Override
    public int execute() {

        if(GE_AREA.contains(c.getLocalPlayer()) && c.getInventory().contains(NOTED_LOG)){
            int GET_AXE = 0;
            int level = c.getSkills().getRealLevel(Skill.WOODCUTTING);
            if(level < 11 && level >= 6)
                GET_AXE = 1; // steel axe
            else if(level < 21 && level >= 11)
                GET_AXE = 2; // black axe
            else if(level < 31 && level >= 21)
                GET_AXE = 3; // mithril axe
            else if(level < 41 && level >= 31)
                GET_AXE= 4; // adamant axe
            else{
                GET_AXE = 5; // rune axe
            }

            return GET_AXE;
        }





        c.log("Executing sellingnode");
        if (c.getInventory().contains(NOTED_LOG)) {
            c.log("has logs");
            c.getGrandExchange().open();
            if (c.getGrandExchange().isOpen()) {
                c.log("GE IS OPEN");
                if (c.getInventory().interact(NOTED_LOG, "Offer")) {
                    if (c.getGrandExchange().confirm()) {
                        if (c.getGrandExchange().isReadyToCollect()) {
                           c.getGrandExchange().collect();
                        } else {
                            c.sleep(10000);
                        }
                    }
                }


            }


        } else if (c.getInventory().contains(COINS) && c.getInventory().count(COINS) >= 4567) {
            if (c.getGrandExchange().isOpen()) {
                if (!c.getInventory().contains(BLACK_AXE)) {
                    c.getGrandExchange().buyItem("Black axe", 1, 1500);
                } else {
                    return 1000;
                }
            } else {
                c.getGrandExchange().open();
            }
        }
        return 1000;
    }
}

