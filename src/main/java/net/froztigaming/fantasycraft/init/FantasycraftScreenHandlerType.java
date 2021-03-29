package net.froztigaming.fantasycraft.init;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.blocks.containers.ChestTypes;
import net.froztigaming.fantasycraft.screenhandlers.FantasycraftChestScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class FantasycraftScreenHandlerType {

    public static ScreenHandlerType<FantasycraftChestScreenHandler> ELVEN_CHEST;

    public static void registerScreenHandlers() {
        ELVEN_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(FantasycraftMain.MOD_ID, "elven_chest"), (syncId, inventory) -> new FantasycraftChestScreenHandler(ELVEN_CHEST, ChestTypes.ELVEN, syncId, inventory, ScreenHandlerContext.EMPTY));
    }
}
