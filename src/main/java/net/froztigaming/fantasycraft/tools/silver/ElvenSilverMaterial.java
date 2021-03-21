package net.froztigaming.fantasycraft.tools.silver;

import net.froztigaming.fantasycraft.init.ItemInit;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ElvenSilverMaterial implements ToolMaterial {

    public static final ElvenSilverMaterial INSTANCE = new ElvenSilverMaterial();

    @Override
    public int getDurability() {
        return 2000;
    }
    public float getMiningSpeedMultiplier() {
        return 9.0f;
    }
    public float getAttackDamage() {
        return 0.0f;
    }
    public int getMiningLevel() {
        return 3;
    }
    public int getEnchantability() {
        return 30;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemInit.SILVER_INGOT);
    }
}
