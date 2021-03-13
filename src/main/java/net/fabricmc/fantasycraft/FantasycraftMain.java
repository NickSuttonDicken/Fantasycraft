package net.fabricmc.fantasycraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fantasycraft.register.Registration;

public class FantasycraftMain implements ModInitializer {
	@Override
	public void onInitialize() {
		Registration.start();
	}
}
