package net.froztigaming.fantasycraft.tools.dwarvensteel;

import net.froztigaming.fantasycraft.register.Registration;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DwarvenSteelMaterial implements ToolMaterial {

    public static final DwarvenSteelMaterial INSTANCE = new DwarvenSteelMaterial();

    @Override
    public int getDurability() {
        return 2500;
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
        return 15;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Registration.MITHRIL_INGOT);
    }
}
