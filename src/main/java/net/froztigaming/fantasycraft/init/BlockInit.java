package net.froztigaming.fantasycraft.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.blocks.containers.DwarvenBlastFurnace;
import net.froztigaming.fantasycraft.blocks.containers.ElvenChest;
import net.froztigaming.fantasycraft.blocks.materialblocks.BronzeBlock;
import net.froztigaming.fantasycraft.blocks.materialblocks.MithrilBlock;
import net.froztigaming.fantasycraft.blocks.materialblocks.PrismarineBlock;
import net.froztigaming.fantasycraft.blocks.materialblocks.SilverBlock;
import net.froztigaming.fantasycraft.blocks.ores.BronzeOre;
import net.froztigaming.fantasycraft.blocks.ores.MithrilOre;
import net.froztigaming.fantasycraft.blocks.ores.SilverOre;
import net.froztigaming.fantasycraft.config.FantasycraftConfig;
import net.froztigaming.fantasycraft.entity.DwarvenBlastFurnaceEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

import static net.froztigaming.fantasycraft.FantasycraftMain.Fantasycraft;

public class BlockInit {

    static boolean bronzeEnable = FantasycraftMain.CONFIG.METALS.bronzeEnable;
    static boolean silverEnable = FantasycraftMain.CONFIG.METALS.silverEnable;
    static boolean prismarineEnable = FantasycraftMain.CONFIG.METALS.prismarineEnable;
    static boolean mithrilEnable = FantasycraftMain.CONFIG.METALS.mithrilEnable;

    //Blocks
    public static final DwarvenBlastFurnace DWARVEN_BLAST_FURNACE = new DwarvenBlastFurnace(FabricBlockSettings.of(Material.METAL).strength(4.5f).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
    public static final Block ELVEN_CHEST = new ElvenChest();
    public static final MithrilBlock MITHRIL_BLOCK = new MithrilBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final BronzeBlock BRONZE_BLOCK = new BronzeBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    public static final SilverBlock SILVER_BLOCK = new SilverBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    public static final PrismarineBlock PRISMARINE_BLOCK = new PrismarineBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    public static final MithrilOre MITHRIL_ORE = new MithrilOre(FabricBlockSettings.of(Material.STONE).breakByHand(false).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final BronzeOre BRONZE_ORE = new BronzeOre(FabricBlockSettings.of(Material.STONE).breakByHand(false).strength(3.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    public static final SilverOre SILVER_ORE = new SilverOre(FabricBlockSettings.of(Material.STONE).breakByHand(false).strength(3.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

    //Block Entities
    public static BlockEntityType DWARVEN_BLAST_FURNACE_ENTITY = BlockEntityType.Builder.create(DwarvenBlastFurnaceEntity::new, DWARVEN_BLAST_FURNACE).build(null);

    //Block
    public static void registerBlocks()
    {
        {
            if (bronzeEnable)
            {
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "bronze_ore"), BRONZE_ORE);
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "bronze_block"), BRONZE_BLOCK);
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "dwarven_blast_furnace"), DWARVEN_BLAST_FURNACE);
            }

            if (silverEnable)
            {
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "silver_ore"), SILVER_ORE);
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "silver_block"), SILVER_BLOCK);
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "elven_chest"), ELVEN_CHEST);
            }

            if (prismarineEnable)
            {
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "prismarine_block"), PRISMARINE_BLOCK);
            }

            if (mithrilEnable)
            {
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "mithril_ore"), MITHRIL_ORE);
                Registry.register(Registry.BLOCK, new Identifier(FantasycraftMain.MOD_ID, "mithril_block"), MITHRIL_BLOCK);
            }
        }
    }

    //Block Item
    public static void registerBlockItems()
    {
        {
            if (bronzeEnable) {
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "bronze_ore"), new BlockItem(BRONZE_ORE, new FabricItemSettings().group(Fantasycraft)));
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "bronze_block"), new BlockItem(BRONZE_BLOCK, new FabricItemSettings().group(Fantasycraft)));
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_blast_furnace"), new BlockItem(DWARVEN_BLAST_FURNACE, new FabricItemSettings().group(Fantasycraft)));
            }

            if (silverEnable) {
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings().group(Fantasycraft)));
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "silver_block"), new BlockItem(SILVER_BLOCK, new FabricItemSettings().group(Fantasycraft)));
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_chest"), new BlockItem(ELVEN_CHEST, new FabricItemSettings().group(Fantasycraft)));
            }

            if (prismarineEnable) {
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "prismarine_block"), new BlockItem(PRISMARINE_BLOCK, new FabricItemSettings().group(Fantasycraft)));
            }

            if (mithrilEnable) {
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_ore"), new BlockItem(MITHRIL_ORE, new FabricItemSettings().group(Fantasycraft)));
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_block"), new BlockItem(MITHRIL_BLOCK, new FabricItemSettings().group(Fantasycraft)));
            }
        }
    }

    //Entities ItemInit
    public static void registerBlockEntities()
    {
        {
            if (bronzeEnable)
            {
                Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(FantasycraftMain.MOD_ID, "dwarven_blast_furnace"), DWARVEN_BLAST_FURNACE_ENTITY);
            }
        }
    }
}
