package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;
import static net.archasmiel.thaumcraft.lib.gen.ItemDataGen.simpleItemModel;



public class BasicThaumcraftItem extends ThaumcraftItem {



    public BasicThaumcraftItem(Item item, String name) {
        super(item, name);
    }
    public BasicThaumcraftItem(Item item, String name, int color) {
        super(item, name, color);
    }



    public void model() {
        simpleItemModel("generated", name(), name());
    }

    public void register() {

        if (color() == 0x000000)
            setItem(Register.registerItem(name(), item()));
        else
            setItem(Register.registerItem(name(), item(), color()));

        setRegistered(true);
    }

    public void load() {
        model();
        register();
    }

}
