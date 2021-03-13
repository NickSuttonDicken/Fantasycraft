package net.fabricmc.fantasycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fantasycraft.FantasycraftMain;

@Environment(EnvType.CLIENT)
public class FantasycraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(FantasycraftMain.DWARVEN_BLAST_FURNACE_SCREEN_HANDLER, DwarvenBlastFurnaceScreen::new);
    }
}
