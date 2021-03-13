package net.fabricmc.fantasycraft.entity;

import net.fabricmc.fantasycraft.FantasycraftMain;
import net.fabricmc.fantasycraft.client.DwarvenBlastFurnaceScreenHandler;
import net.fabricmc.fantasycraft.register.Registration;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class DwarvenBlastFurnaceEntity extends AbstractFurnaceBlockEntity {
    public DwarvenBlastFurnaceEntity(){
        super(Registration.DWARVEN_BLAST_FURNACE_ENTITY, Registration.DWARVEN_BLASTING_RECIPE_TYPE);
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
        return new DwarvenBlastFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
