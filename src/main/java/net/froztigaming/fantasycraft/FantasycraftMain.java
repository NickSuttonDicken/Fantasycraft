package net.froztigaming.fantasycraft;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.froztigaming.fantasycraft.config.FantasycraftConfig;
import net.froztigaming.fantasycraft.init.BlockInit;
import net.froztigaming.fantasycraft.init.ItemInit;
import net.froztigaming.fantasycraft.world.ModConfiguredFeatures;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class FantasycraftMain implements ModInitializer {

	//Mod Details
	public static final String MOD_ID = "fantasycraft";
	//Item Group
	public static final ItemGroup Fantasycraft = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(ItemInit.MITHRIL_SWORD))
			.build();

	public static final Identifier PacketID = new Identifier(MOD_ID, "spawn_packet");
	public static final FantasycraftConfig CONFIG = AutoConfig.register(FantasycraftConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new)).getConfig();

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}

	@Override
	public void onInitialize() {
		BlockInit.registerBlockEntities();
		BlockInit.registerBlocks();
		BlockInit.registerBlockItems();
		ItemInit.registerItems();
		ModConfiguredFeatures.Features();
	}
}
