package net.froztigaming.fantasycraft.tools.silver;

import net.froztigaming.fantasycraft.register.Registration;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ElvenMaterial implements ToolMaterial {

    public static final ElvenMaterial INSTANCE = new ElvenMaterial();

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
        return Ingredient.ofItems(Registration.MITHRIL_INGOT);
    }
}
