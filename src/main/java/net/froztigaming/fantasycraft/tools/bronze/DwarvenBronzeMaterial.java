package net.froztigaming.fantasycraft.tools.bronze;

import net.froztigaming.fantasycraft.init.ItemInit;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DwarvenBronzeMaterial implements ToolMaterial {

    public static final DwarvenBronzeMaterial INSTANCE = new DwarvenBronzeMaterial();

    @Override
    public int getDurability() {
        return 2000;
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
        return 10;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemInit.BRONZE_INGOT);
    }
}
