package net.fabricmc.fantasycraft.recipe;

import net.fabricmc.fantasycraft.FantasycraftMain;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class DwarvenBlasting extends AbstractCookingRecipe {
    public DwarvenBlasting(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(FantasycraftMain.DWARVEN_BLASTING_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(FantasycraftMain.DWARVEN_BLAST_FURNACE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FantasycraftMain.DWARVEN_BLASTING_RECIPE_SERIALIZER;
    }
}
