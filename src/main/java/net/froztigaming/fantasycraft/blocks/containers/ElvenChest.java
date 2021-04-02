package net.froztigaming.fantasycraft.blocks.containers;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.froztigaming.fantasycraft.init.FantasycraftBlockEntityType;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ElvenChest extends GenericFantasycraftChestBlock {
    public ElvenChest() {
        super(FabricBlockSettings.of(Material.METAL)
                        .hardness(1.0F)
                        .sounds(BlockSoundGroup.METAL)
                        .breakByTool(FabricToolTags.PICKAXES, 0),
                ChestTypes.ELVEN,
                () -> FantasycraftBlockEntityType.ELVEN_CHEST);
    }
}
