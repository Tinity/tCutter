package Tinity.Nodes;

import Tinity.MyFirstNodeScript;
import Tinity.Node;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.container.impl.bank.BankMode;

public class BankNode extends Node {


    private final int LOG = 1511;
    public BankNode(MyFirstNodeScript main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return c.getInventory().isFull();
    }

    @Override
    public int execute() {
        c.log("Banking...");
        if (c.getBank().isOpen()) {
            c.getBank().depositAllExcept(item -> item != null && item.getName().contains(" axe"));
            if (c.getBank().contains(LOG) && c.getBank().count(LOG) >= 100) {
                if (c.getBank().getWithdrawMode() == BankMode.NOTE) {
                    c.getBank().withdrawAll(LOG);
                } else {
                    c.getBank().setWithdrawMode(BankMode.NOTE);
                }

            }
        } else {
            c.getBank().open(BankLocation.VARROCK_WEST);
        }
        return 1000;
    }
}
