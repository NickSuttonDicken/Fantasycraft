package net.fabricmc.fantasycraft.tools;

import net.fabricmc.fantasycraft.FantasycraftMain;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MithrilMaterial implements ToolMaterial {

    public static final MithrilMaterial INSTANCE = new MithrilMaterial();

    @Override
    public int getDurability() {
        return 3069;
    }
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }
    public float getAttackDamage() {
        return 0.0f;
    }
    public int getMiningLevel() {
        return 4;
    }
    public int getEnchantability() {
        return 22;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(FantasycraftMain.MITHRIL_INGOT);
    }
}
