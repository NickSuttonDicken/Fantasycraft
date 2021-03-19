package net.froztigaming.fantasycraft;

import net.fabricmc.api.ModInitializer;
import net.froztigaming.fantasycraft.register.Registration;

public class FantasycraftMain implements ModInitializer {

	@Override
	public void onInitialize() {
		Registration.register();
	}
}
