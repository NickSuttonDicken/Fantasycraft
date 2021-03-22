package net.froztigaming.fantasycraft.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.armor.*;
import net.froztigaming.fantasycraft.entity.ElvenArrowEntity;
import net.froztigaming.fantasycraft.items.SilverArrowHead;
import net.froztigaming.fantasycraft.items.StoneRod;
import net.froztigaming.fantasycraft.tools.bronze.*;
import net.froztigaming.fantasycraft.tools.prismarine.*;
import net.froztigaming.fantasycraft.tools.silver.*;
import net.froztigaming.fantasycraft.items.ingots.BronzeIngot;
import net.froztigaming.fantasycraft.items.ingots.PrismarineIngot;
import net.froztigaming.fantasycraft.items.ingots.MithrilIngot;
import net.froztigaming.fantasycraft.items.ingots.SilverIngot;
import net.froztigaming.fantasycraft.tools.mithril.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.froztigaming.fantasycraft.FantasycraftMain.Fantasycraft;

public class ItemInit {

    static boolean bronzeEnable = FantasycraftMain.CONFIG.METALS.bronzeEnable;
    static boolean silverEnable = FantasycraftMain.CONFIG.METALS.silverEnable;
    static boolean prismarineEnable = FantasycraftMain.CONFIG.METALS.prismarineEnable;
    static boolean mithrilEnable = FantasycraftMain.CONFIG.METALS.mithrilEnable;

    //Armor Materials
    public static final ArmorMaterial MITHRIL_ARMOR_MATERIAL = new MithrilArmorMaterial();
    public static final ArmorMaterial DWARVEN_ARMOR_MATERIAL = new DwarvenArmorMaterial();
    public static final ArmorMaterial ELVEN_ARMOR_MATERIAL = new ElvenArmorMaterial();
    public static final ArmorMaterial TRITON_ARMOR_MATERIAL = new TritonArmorMaterial();

    //Items
    public static final MithrilIngot MITHRIL_INGOT = new MithrilIngot(new Item.Settings().group(Fantasycraft).fireproof());
    public static final SilverIngot SILVER_INGOT = new SilverIngot(new Item.Settings().group(Fantasycraft));
    public static final BronzeIngot BRONZE_INGOT = new BronzeIngot(new Item.Settings().group(Fantasycraft));
    public static final PrismarineIngot PRISMARINE_INGOT = new PrismarineIngot(new Item.Settings().group(Fantasycraft));
    public static final StoneRod STONE_ROD = new StoneRod(new Item.Settings().group(Fantasycraft));
    public static final SilverArrowHead SILVER_ARROW_HEAD = new SilverArrowHead(new Item.Settings().group(Fantasycraft));


    //Tools
    public static ToolItem MITHRIL_SHOVEL = new MithrilShovel(MithrilMaterial.INSTANCE, 6.5f, -3.0f, new Item.Settings().group(Fantasycraft).fireproof());
    public static ToolItem MITHRIL_PICKAXE = new MithrilPickaxe(MithrilMaterial.INSTANCE, 7, -2.8f, new Item.Settings().group(Fantasycraft).fireproof());
    public static ToolItem MITHRIL_AXE = new MithrilAxe(MithrilMaterial.INSTANCE, 10, -3.0f, new Item.Settings().group(Fantasycraft).fireproof());
    public static ToolItem MITHRIL_HOE = new MithrilHoe(MithrilMaterial.INSTANCE, 0, 0f, new Item.Settings().group(Fantasycraft).fireproof());
    public static ToolItem MITHRIL_SWORD = new MithrilSword(MithrilMaterial.INSTANCE, 8, -2.4f, new Item.Settings().group(Fantasycraft).fireproof());
    public static ToolItem DWARVEN_SHOVEL = new DwarvenShovel(DwarvenBronzeMaterial.INSTANCE, 5.5f, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem DWARVEN_PICKAXE = new DwarvenPickaxe(DwarvenBronzeMaterial.INSTANCE, 6, -2.8f, new Item.Settings().group(Fantasycraft));
    public static ToolItem DWARVEN_AXE = new DwarvenAxe(DwarvenBronzeMaterial.INSTANCE, 9, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem DWARVEN_HOE = new DwarvenHoe(DwarvenBronzeMaterial.INSTANCE, 0, 0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem DWARVEN_SWORD = new DwarvenSword(DwarvenBronzeMaterial.INSTANCE, 7, -2.4f, new Item.Settings().group(Fantasycraft));
    public static ToolItem ELVEN_SHOVEL = new ElvenShovel(ElvenSilverMaterial.INSTANCE, 5.5f, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem ELVEN_PICKAXE = new ElvenPickaxe(ElvenSilverMaterial.INSTANCE, 6, -2.8f, new Item.Settings().group(Fantasycraft));
    public static ToolItem ELVEN_AXE = new ElvenAxe(ElvenSilverMaterial.INSTANCE, 9, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem ELVEN_HOE = new ElvenHoe(ElvenSilverMaterial.INSTANCE, 0, 0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem ELVEN_SWORD = new ElvenSword(ElvenSilverMaterial.INSTANCE, 7, -2.4f, new Item.Settings().group(Fantasycraft));
    public static RangedWeaponItem ELVEN_BOW = new ElvenBow(new Item.Settings().group(Fantasycraft).maxDamage(770));
    public static final ElvenArrow ELVEN_ARROW = new ElvenArrow(new Item.Settings().group(Fantasycraft));
    public static ToolItem TRITON_SHOVEL = new TritonShovel(TritonPrismarineMaterial.INSTANCE, 5.5f, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem TRITON_PICKAXE = new TritonPickaxe(TritonPrismarineMaterial.INSTANCE, 6, -2.8f, new Item.Settings().group(Fantasycraft));
    public static ToolItem TRITON_AXE = new TritonAxe(TritonPrismarineMaterial.INSTANCE, 9, -3.0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem TRITON_HOE = new TritonHoe(TritonPrismarineMaterial.INSTANCE, 0, 0f, new Item.Settings().group(Fantasycraft));
    public static ToolItem TRITON_SWORD = new TritonSword(TritonPrismarineMaterial.INSTANCE, 7, -2.4f, new Item.Settings().group(Fantasycraft));


    //Armor
    public static final Item MITHRIL_HELMET = new MithrilArmor(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Fantasycraft).fireproof());
    public static final Item MITHRIL_CHESTPLATE = new MithrilArmor(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Fantasycraft).fireproof());
    public static final Item MITHRIL_LEGGINGS = new MithrilArmor(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Fantasycraft).fireproof());
    public static final Item MITHRIL_BOOTS = new MithrilArmor(MITHRIL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Fantasycraft).fireproof());
    public static final Item DWARVEN_HELMET = new DwarvenArmor(DWARVEN_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Fantasycraft));
    public static final Item DWARVEN_CHESTPLATE = new DwarvenArmor(DWARVEN_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Fantasycraft));
    public static final Item DWARVEN_LEGGINGS = new DwarvenArmor(DWARVEN_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Fantasycraft));
    public static final Item DWARVEN_BOOTS = new DwarvenArmor(DWARVEN_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Fantasycraft));
    public static final Item ELVEN_HELMET = new ElvenArmor(ELVEN_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Fantasycraft));
    public static final Item ELVEN_CHESTPLATE = new ElvenArmor(ELVEN_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Fantasycraft));
    public static final Item ELVEN_LEGGINGS = new ElvenArmor(ELVEN_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Fantasycraft));
    public static final Item ELVEN_BOOTS = new ElvenArmor(ELVEN_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Fantasycraft));
    public static final Item TRITON_HELMET = new TritonArmor(TRITON_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Fantasycraft));
    public static final Item TRITON_CHESTPLATE = new TritonArmor(TRITON_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Fantasycraft));
    public static final Item TRITON_LEGGINGS = new TritonArmor(TRITON_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Fantasycraft));
    public static final Item TRITON_BOOTS = new TritonArmor(TRITON_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Fantasycraft));

    //Entities
    public static EntityType<ElvenArrowEntity> ELVEN_ARROW_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(FantasycraftMain.MOD_ID, "elven_arrow"),
            FabricEntityTypeBuilder.<ElvenArrowEntity>create(SpawnGroup.MISC, ElvenArrowEntity::new)
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
            .build()
    );

    //Items ItemInit
    public static void registerItems()
    {
        {
            Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "stone_rod"), STONE_ROD);

            if (bronzeEnable)
            {
                //Items
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "bronze_ingot"), BRONZE_INGOT);

                //Tools
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_pickaxe"), DWARVEN_PICKAXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_shovel"), DWARVEN_SHOVEL);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_axe"), DWARVEN_AXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_hoe"), DWARVEN_HOE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_sword"), DWARVEN_SWORD);

                //Armor
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_helmet"), DWARVEN_HELMET);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_chestplate"), DWARVEN_CHESTPLATE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_leggings"), DWARVEN_LEGGINGS);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "dwarven_boots"), DWARVEN_BOOTS);
            }

            if (silverEnable)
            {
                //Items
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "silver_ingot"), SILVER_INGOT);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "silver_arrow_head"), SILVER_ARROW_HEAD);

                //Tools
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_pickaxe"), ELVEN_PICKAXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_shovel"), ELVEN_SHOVEL);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_axe"), ELVEN_AXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_hoe"), ELVEN_HOE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_sword"), ELVEN_SWORD);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_bow"), ELVEN_BOW);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_arrow"), ELVEN_ARROW);

                //Armor
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_helmet"), ELVEN_HELMET);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_chestplate"), ELVEN_CHESTPLATE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_leggings"), ELVEN_LEGGINGS);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "elven_boots"), ELVEN_BOOTS);
            }

            if (prismarineEnable)
            {
                //Items
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "prismarine_ingot"), PRISMARINE_INGOT);

                //Tools
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_pickaxe"), TRITON_PICKAXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_shovel"), TRITON_SHOVEL);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_axe"), TRITON_AXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_hoe"), TRITON_HOE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_sword"), TRITON_SWORD);

                //Armor
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_helmet"), TRITON_HELMET);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_chestplate"), TRITON_CHESTPLATE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_leggings"), TRITON_LEGGINGS);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "triton_boots"), TRITON_BOOTS);
            }
            if (mithrilEnable)
            {
                //Items
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_ingot"), MITHRIL_INGOT);

                //Tools
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_pickaxe"), MITHRIL_PICKAXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_shovel"), MITHRIL_SHOVEL);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_axe"), MITHRIL_AXE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_hoe"), MITHRIL_HOE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_sword"), MITHRIL_SWORD);

                //Armor ItemInit
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_helmet"), MITHRIL_HELMET);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_chestplate"), MITHRIL_CHESTPLATE);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_leggings"), MITHRIL_LEGGINGS);
                Registry.register(Registry.ITEM, new Identifier(FantasycraftMain.MOD_ID, "mithril_boots"), MITHRIL_BOOTS);
            }
        }
    }
}
