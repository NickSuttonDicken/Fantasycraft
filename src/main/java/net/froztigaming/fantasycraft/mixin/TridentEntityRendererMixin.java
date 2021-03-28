package net.froztigaming.fantasycraft.mixin;


import net.froztigaming.fantasycraft.init.ItemInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;

import static net.froztigaming.fantasycraft.FantasycraftMain.id;

@Mixin(TridentEntityRenderer.class)
public class TridentEntityRendererMixin {
    @Inject(method = "getTexture", at = @At(value = "HEAD"), cancellable = true)
    public void getTextureMixin(TridentEntity entity, CallbackInfoReturnable<Identifier> cir) {
        if(entity.tridentStack.getItem() == ItemInit.TRITON_TRIDENT) {
            cir.setReturnValue(id("textures/entity/netherite_trident.png"));
        }
    }
}
