package net.froztigaming.fantasycraft.blocks.containers;

import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.entity.ElvenChestEntity;
import net.froztigaming.fantasycraft.entity.GenericFantasycraftChestEntity;
import net.froztigaming.fantasycraft.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public enum ChestTypes {

    ELVEN(54, 9, 184, 222, new Identifier(FantasycraftMain.MOD_ID, "entity/chest/elven_chest"), 256, 256);


    public final int size;
    public final int rowLength;
    public final int xSize;
    public final int ySize;
    public final Identifier texture;
    public final int textureXSize;
    public final int textureYSize;

    ChestTypes(int size, int rowLength, int xSize, int ySize, Identifier texture, int textureXSize, int textureYSize) {
        this.size = size;
        this.rowLength = rowLength;
        this.xSize = xSize;
        this.ySize = ySize;
        this.texture = texture;
        this.textureXSize = textureXSize;
        this.textureYSize = textureYSize;
    }

    public int getRowCount() {
        return this.size / this.rowLength;
    }

    public static Block get(ChestTypes type) {
        switch (type) {
            case ELVEN:
                return BlockInit.ELVEN_CHEST;
            default:
                return Blocks.CHEST;
        }
    }

    public GenericFantasycraftChestEntity makeEntity() {
        switch (this) {
            case ELVEN:
                return new ElvenChestEntity();
            default:
                return null;
        }
    }
}
