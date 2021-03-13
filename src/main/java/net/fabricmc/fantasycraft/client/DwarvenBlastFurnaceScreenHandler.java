package net.fabricmc.fantasycraft.client;

import net.fabricmc.fantasycraft.FantasycraftMain;
import net.fabricmc.fantasycraft.register.Registration;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class DwarvenBlastFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
    public DwarvenBlastFurnaceScreenHandler(int i, PlayerInventory playerInventory) {
        super(Registration.DWARVEN_BLAST_FURNACE_SCREEN_HANDLER, Registration.DWARVEN_BLASTING_RECIPE_TYPE, RecipeBookCategory.BLAST_FURNACE, i, playerInventory);
    }

    public DwarvenBlastFurnaceScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(Registration.DWARVEN_BLAST_FURNACE_SCREEN_HANDLER, Registration.DWARVEN_BLASTING_RECIPE_TYPE, RecipeBookCategory.BLAST_FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
