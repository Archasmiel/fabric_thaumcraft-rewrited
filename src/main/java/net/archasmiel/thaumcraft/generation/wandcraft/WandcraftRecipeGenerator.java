package net.archasmiel.thaumcraft.generation.wandcraft;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Scepter;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Staff;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class WandcraftRecipeGenerator {

    public static void wandRecipe(String mod_id, Wand item) {
        if (item != null) {
            String rod = item.getRod().isStick() ? "minecraft:stick" : Thaumcraft.MOD_ID + ":wand_" + item.getRod().getRegistryName();
            String cap = Thaumcraft.MOD_ID + ":" + item.getCap().getRegistryName();

            RESOURCE_PACK.addRecipe(
                    new Identifier(
                        mod_id,
                        item.name()
                    ),
                    JRecipe.shaped(
                        JPattern.pattern("  c", " r ", "c  "),
                        JKeys.keys()
                            .key("c", JIngredient.ingredient().item(cap))
                            .key("r", JIngredient.ingredient().item(rod)),
                        JResult.result(Thaumcraft.MOD_ID + ":" + item.name())
                    )
            );

        }
    }

    public static void scepterRecipe(String mod_id, Scepter item) {
        // scepters have same rod as wands
        if (item != null) {
            String rod = item.getRod().isStick() ? "minecraft:stick" : Thaumcraft.MOD_ID + ":wand_" + item.getRod().getRegistryName();
            String cap = Thaumcraft.MOD_ID + ":" + item.getCap().getRegistryName();
            String charm = "thaumcraft:primal_charm";

            RESOURCE_PACK.addRecipe(
                    new Identifier(
                            mod_id,
                            item.name()
                    ),
                    JRecipe.shaped(
                            JPattern.pattern(" ca", " rc", "c  "),
                            JKeys.keys()
                                    .key("c", JIngredient.ingredient().item(cap))
                                    .key("r", JIngredient.ingredient().item(rod))
                                    .key("a", JIngredient.ingredient().item(charm)),
                            JResult.result(Thaumcraft.MOD_ID + ":" + item.name())
                    )
            );

        }
    }

    public static void staffRecipe(String mod_id, Staff item) {
        // staffs have different rod as wands
        if (item != null) {
            String rod = mod_id + ":staff_" + item.getRod().getRegistryName();
            String cap = mod_id + ":" + item.getCap().getRegistryName();

            RESOURCE_PACK.addRecipe(
                new Identifier(mod_id, item.name()),
                JRecipe.shaped(
                    JPattern.pattern("  c", " r ", "c  "),
                    JKeys.keys()
                        .key("c", JIngredient.ingredient().item(cap))
                        .key("r", JIngredient.ingredient().item(rod)),
                    JResult.result(mod_id + ":" + item.name())
                )
            );
        }
    }

    public static void staffCoreRecipe(String mod_id, Staff item) {
        // staffs have different rod as wands
        if (item != null) {


            // registering staff core recipe
            // primal staff core only crafted on infusion
            // and there's no wooden staff core ever existed
            String rod = mod_id + ":staff_" + item.getRod().getRegistryName();
            String wand_rod = mod_id + ":wand_" + item.getRod().getRegistryName();
            String charm = "thaumcraft:primal_charm";
            if (!item.getRod().isPrimal()) {
                RESOURCE_PACK.addRecipe(
                        new Identifier(mod_id, "staff_" + item.getRod().getRegistryName()),
                        JRecipe.shaped(
                                JPattern.pattern("  a", " r ", "r  "),
                                JKeys.keys()
                                        .key("a", JIngredient.ingredient().item(charm))
                                        .key("r", JIngredient.ingredient().item(wand_rod)),
                                JResult.result(rod)
                        )
                );
            }
        }
    }

}
