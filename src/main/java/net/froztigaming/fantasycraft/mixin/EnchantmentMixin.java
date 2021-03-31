package net.froztigaming.fantasycraft.mixin;

import net.froztigaming.fantasycraft.tools.prismarine.TritonTrident;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void isAcceptableItemMixin(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (((Object) this == Enchantments.RIPTIDE || (Object) this == Enchantments.IMPALING
                || (Object) this == Enchantments.LOYALTY || (Object) this == Enchantments.CHANNELING) && stack.getItem() instanceof TritonTrident) {
            info.setReturnValue(true);
        }
    }
}
