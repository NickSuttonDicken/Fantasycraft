package net.froztigaming.fantasycraft.entity;

import net.froztigaming.fantasycraft.register.Registration;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.BlastFurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class DwarvenBlastFurnaceEntity extends AbstractFurnaceBlockEntity {
    public DwarvenBlastFurnaceEntity(){
        super(Registration.DWARVEN_BLAST_FURNACE_ENTITY, RecipeType.BLASTING);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("Dwarven Blast Furnace");
    }

    @Override
    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 4;
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new BlastFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected int getCookTime() {
        int cookTime = this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).map(AbstractCookingRecipe::getCookTime).orElse(100);
        return(int)(cookTime / 2);
    }
}
