package net.froztigaming.fantasycraft.world;

import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.config.FantasycraftConfig;
import net.froztigaming.fantasycraft.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class OreGen {

    public static final FantasycraftConfig.Metals CONFIG = FantasycraftMain.CONFIG.METALS;

    public static ConfiguredFeature<?,?> ORE_MITHRIL_END = Feature.NO_SURFACE_ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    BlockInit.MITHRIL_ORE.getDefaultState(),
                    CONFIG.mithrilVeinSize))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    CONFIG.mithrilMinLevel,
                    CONFIG.mithrilMaxLevel
            )))
            .spreadHorizontally()
            .repeat(CONFIG.mithrilPerChunk);

    public static ConfiguredFeature<?, ?> ORE_BRONZE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockInit.BRONZE_ORE.getDefaultState(),
                    CONFIG.bronzeVeinSize))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    CONFIG.bronzeMinLevel,
                    CONFIG.bronzeMaxLevel
            )))
            .spreadHorizontally()
            .repeat(CONFIG.bronzePerChunk);

    public static ConfiguredFeature<?, ?> ORE_SILVER_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockInit.SILVER_ORE.getDefaultState(),
                    CONFIG.silverVeinSize))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    CONFIG.silverMinLevel,
                    CONFIG.silverMaxLevel
            )))
            .spreadHorizontally()
            .repeat(CONFIG.silverPerChunk);
}
