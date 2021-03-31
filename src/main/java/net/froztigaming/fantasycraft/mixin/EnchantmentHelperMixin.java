package net.froztigaming.fantasycraft.mixin;

import net.froztigaming.fantasycraft.tools.prismarine.TritonTrident;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getPossibleEntries(ILnet/minecraft/item/ItemStack;Z)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void getPossibleEntriesMixin(int i, ItemStack stack, boolean treasureAllowed,
                                                CallbackInfoReturnable<List<EnchantmentLevelEntry>> info) {
        if (stack.getItem() instanceof TritonTrident) {
            List<EnchantmentLevelEntry> currentEnchantments = info.getReturnValue();
            List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
            currentEnchantments.forEach(enchantment -> {
                if (!(enchantment.enchantment.type == EnchantmentTarget.TRIDENT)
                        || enchantment.enchantment == Enchantments.IMPALING) {
                    enchantments.add(enchantment);
                }
            });
            Enchantment piercing = Enchantments.PIERCING;
            for (int level = piercing.getMaxLevel(); level > piercing.getMinLevel() - 1; --level) {
                if (i >= piercing.getMinPower(level) && i <= piercing.getMaxPower(level)) {
                    enchantments.add(new EnchantmentLevelEntry(piercing, level));
                    break;
                }
            }
            info.setReturnValue(enchantments);
        }
    }
}
