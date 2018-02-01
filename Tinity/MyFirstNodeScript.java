package Tinity;

import Tinity.Nodes.*;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.WOODCUTTING, name = "tCutter", author = "Tinity", version = 1.0, description = "Cuts trees")
public class MyFirstNodeScript extends AbstractScript {
    private Node[] nodes;

    @Override
    public void onStart() {
        nodes = new Node[]{
                new BankNode(this),
                new RunToGeNode(this),
                new SellingNode(this),
                new WalkNode(this),
                new CutNode(this),
                new GoBackNode(this),

        };
    }

    @Override
    public int onLoop() {
        for (Node node : nodes) {
            if (node.validate()) {
                return node.execute();
            }
        }
        log("No node valid");
        return Calculations.random(1000, 2500);
    }
}
