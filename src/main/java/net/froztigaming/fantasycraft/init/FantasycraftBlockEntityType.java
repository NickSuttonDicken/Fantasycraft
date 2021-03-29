package net.froztigaming.fantasycraft.init;

import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.entity.ElvenChestEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FantasycraftBlockEntityType {

    public static final BlockEntityType<ElvenChestEntity> ELVEN_CHEST = BlockEntityType.Builder.create(ElvenChestEntity::new, BlockInit.ELVEN_CHEST).build(null);


    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(FantasycraftMain.MOD_ID, "elven_chest"), ELVEN_CHEST);
    }
}
