package net.froztigaming.fantasycraft.register;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.froztigaming.fantasycraft.armor.MithrilArmorMaterial;
import net.froztigaming.fantasycraft.blocks.containers.DwarvenBlastFurnace;
import net.froztigaming.fantasycraft.blocks.materialblocks.MithrilBlock;
import net.froztigaming.fantasycraft.blocks.ores.MithrilOre;
import net.froztigaming.fantasycraft.entity.DwarvenBlastFurnaceEntity;
import net.froztigaming.fantasycraft.entity.ElvenArrowEntity;
import net.froztigaming.fantasycraft.items.ElvenArrow;
import net.froztigaming.fantasycraft.items.ingots.MithrilIngot;
import net.froztigaming.fantasycraft.tools.ElvenBow;
import net.froztigaming.fantasycraft.tools.mithril.*;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Registration {

    //Mod Details
    public static final String MOD_ID = "fantasycraft";
    public static final String MOD_NAME = "Fantasycraft";

    //Item Group
    public static final ItemGroup Fantasycraft = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "general"))
            .icon(() -> new ItemStack(Registration.MITHRIL_SWORD))
            .build();

    //Items
    public static final MithrilIngot MITHRIL_INGOT = new MithrilIngot(new Item.Settings().group(Fantasycraft));
    public static final ElvenArrow ELVEN_ARROW = new ElvenArrow(new Item.Settings().group(Fantasycraft));

    //Blocks
    public static final DwarvenBlastFurnace DWARVEN_BLAST_FURNACE = new DwarvenBlastFurnace(FabricBlockSettings.of(Material.METAL));
    public static final MithrilBlock MITHRIL_BLOCK = new MithrilBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final MithrilOre MITHRIL_ORE = new MithrilOre(FabricBlockSettings.of(Material.STONE).breakByHand(false).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());

    //Tools
    public static ToolItem MITHRIL_SHOVEL = new MithrilShovel(MithrilMaterial.INSTANCE, 6.5f, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem MITHRIL_PICKAXE = new MithrilPickaxe(MithrilMaterial.INSTANCE, 7, -2.8f, new Item.Settings().group(Fantasycraft));
    public static ToolItem MITHRIL_AXE = new MithrilAxe(MithrilMaterial.INSTANCE, 10, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem MITHRIL_HOE = new MithrilHoe(MithrilMaterial.INSTANCE, 1, 0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem MITHRIL_SWORD = new MithrilSword(MithrilMaterial.INSTANCE, 8, -2.4f, new Item.Settings().group(Fantasycraft));
    public static RangedWeaponItem ELVEN_BOW = new ElvenBow(new Item.Settings().group(Registration.Fantasycraft).maxDamage(14400));


    //Armor
    public static final ArmorMaterial MITHRIL_ARMOR_MATERIAL = new MithrilArmorMaterial();
    public static final Item MITHRIL_HELMET = new ArmorItem(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Fantasycraft));
    public static final Item MITHRIL_CHESTPLATE = new ArmorItem(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Fantasycraft));
    public static final Item MITHRIL_LEGGINGS = new ArmorItem(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Fantasycraft));
    public static final Item MITHRIL_BOOTS = new ArmorItem(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Fantasycraft));

    //Entities
    public static BlockEntityType DWARVEN_BLAST_FURNACE_ENTITY = BlockEntityType.Builder.create(DwarvenBlastFurnaceEntity::new, DWARVEN_BLAST_FURNACE).build(null);
    public static EntityType<ElvenArrowEntity> ELVEN_ARROW_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "elven_arrow"),
            FabricEntityTypeBuilder.<ElvenArrowEntity>create(SpawnGroup.MISC, ElvenArrowEntity::new)
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
            .build()
    );

    //Ore Generation
    private static ConfiguredFeature<?,?> ORE_MITHRIL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Registration.MITHRIL_ORE.getDefaultState(),
                    4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    15
            )))
            .spreadHorizontally()
            .repeat(2);


    public static void register()
    {
        //Blocks Registration
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "mithril_ore"), MITHRIL_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "mithril_block"), MITHRIL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dwarven_blast_furnace"), DWARVEN_BLAST_FURNACE);

        //Items Registration
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_ingot"), MITHRIL_INGOT);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_block"), new BlockItem(MITHRIL_BLOCK, new FabricItemSettings().group(Fantasycraft)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_ore"), new BlockItem(MITHRIL_ORE, new FabricItemSettings().group(Fantasycraft)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dwarven_blast_furnace"), new BlockItem(DWARVEN_BLAST_FURNACE, new FabricItemSettings().group(Fantasycraft)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "elven_arrow"), ELVEN_ARROW);

        //Tools Registration
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_pickaxe"), MITHRIL_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_shovel"), MITHRIL_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_axe"), MITHRIL_AXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_hoe"), MITHRIL_HOE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_sword"), MITHRIL_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "elven_bow"), ELVEN_BOW);

        //Armor Registration
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_helmet"), MITHRIL_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_chestplate"), MITHRIL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_leggings"), MITHRIL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mithril_boots"), MITHRIL_BOOTS);

        //Entities Registration
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "dwarven_blast_furnace"), DWARVEN_BLAST_FURNACE_ENTITY);

        //World Generation Registration
        RegistryKey<ConfiguredFeature<?,?>> oreMithrilOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(MOD_ID, "ore_mithril_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMithrilOverworld.getValue(), ORE_MITHRIL_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMithrilOverworld);
    }

    public static void start(){
        register();
    }


}
