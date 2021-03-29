package net.froztigaming.fantasycraft.entity;

import net.froztigaming.fantasycraft.blocks.containers.ChestTypes;
import net.froztigaming.fantasycraft.init.FantasycraftBlockEntityType;

public class ElvenChestEntity extends GenericFantasycraftChestEntity {

    public ElvenChestEntity() {
        super(FantasycraftBlockEntityType.ELVEN_CHEST, ChestTypes.ELVEN);
    }
}

