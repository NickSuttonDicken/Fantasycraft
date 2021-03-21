package net.froztigaming.fantasycraft.tools.mithril;

import net.froztigaming.fantasycraft.init.ItemInit;
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
        return 30;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemInit.MITHRIL_INGOT);
    }
}
