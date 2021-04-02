package net.froztigaming.fantasycraft.armor;

import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.config.FantasycraftConfig;
import net.froztigaming.fantasycraft.init.ItemInit;
import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class MithrilArmor extends ArmorItem {

    int i;
    public MithrilArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings)
    {
        super(material, slot, settings);
    }

    public static final FantasycraftConfig.BonusEffects CONFIG2 = FantasycraftMain.CONFIG.BONUSEFFECTS;

    static boolean enableArmorSetBonuses = CONFIG2.enableArmorSetBonuses;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient && entity instanceof PlayerEntity && enableArmorSetBonuses)
        {
            PlayerEntity player = (PlayerEntity) entity;

            ItemStack head = player.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack legs = player.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack feet = player.getEquippedStack(EquipmentSlot.FEET);

            if((head.getItem() == ItemInit.MITHRIL_HELMET &&
                    chest.getItem() == ItemInit.MITHRIL_CHESTPLATE &&
                    legs.getItem() == ItemInit.MITHRIL_LEGGINGS &&
                    feet.getItem() == ItemInit.MITHRIL_BOOTS))
            {
                ArmorEffects.giveRegenEffect(world, player);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        tooltip.add( new TranslatableText("item.fantasycraft.mithril_armor.tooltip_1").formatted(Formatting.BOLD) );
        tooltip.add( new TranslatableText("item.fantasycraft.mithril_armor.tooltip_2").formatted(Formatting.RED) );
    }
}
