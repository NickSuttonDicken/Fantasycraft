package net.froztigaming.fantasycraft.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.config.FantasycraftConfig;
import net.froztigaming.fantasycraft.init.ItemInit;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {

    public static final FantasycraftConfig.Metals CONFIG2 = FantasycraftMain.CONFIG.METALS;

    public static void Features()
    {
        if(CONFIG2.bronzeEnable)
        {
            RegistryKey<ConfiguredFeature<?, ?>> oreBronzeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                    new Identifier(FantasycraftMain.MOD_ID, "ore_bronze_overworld"));
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreBronzeOverworld.getValue(), OreGen.ORE_BRONZE_OVERWORLD);
            BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.EXTREME_HILLS), GenerationStep.Feature.UNDERGROUND_ORES, oreBronzeOverworld);
        }

        if(CONFIG2.silverEnable)
        {
            RegistryKey<ConfiguredFeature<?,?>> oreSilverOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                    new Identifier(FantasycraftMain.MOD_ID, "ore_mithril_overworld"));
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSilverOverworld.getValue(), OreGen.ORE_SILVER_OVERWORLD);
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreSilverOverworld);
        }

        if(CONFIG2.mithrilEnable)
        {
            RegistryKey<ConfiguredFeature<?,?>> oreMithrilEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                    new Identifier(FantasycraftMain.MOD_ID, "ore_mithril_end"));
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMithrilEnd.getValue(), OreGen.ORE_MITHRIL_END);
            BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreMithrilEnd);
        }
    }
}
