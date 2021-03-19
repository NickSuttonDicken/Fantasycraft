package net.froztigaming.fantasycraft;

import net.fabricmc.api.ModInitializer;
import net.froztigaming.fantasycraft.register.Registration;
import net.minecraft.util.Identifier;

public class FantasycraftMain implements ModInitializer {

	public static final Identifier PacketID = new Identifier(Registration.MOD_ID, "spawn_packet");

	@Override
	public void onInitialize() {
		Registration.register();
	}
}
