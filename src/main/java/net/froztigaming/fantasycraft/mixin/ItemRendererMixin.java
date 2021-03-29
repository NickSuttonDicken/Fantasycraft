package net.froztigaming.fantasycraft.mixin;

import net.froztigaming.fantasycraft.render.TritonTridentRenderer;
import net.froztigaming.fantasycraft.tools.prismarine.TritonTrident;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Inject(method = "renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;II)V", at = @At("HEAD"), cancellable = true)
    public void renderItemMixin(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode,
                                boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, World world, int light,
                                int overlay, CallbackInfo info) {
        BakedModel model = MinecraftClient.getInstance().getItemRenderer().getHeldItemModel(stack, world, entity);
        if ((stack.getItem() instanceof TritonTrident && TritonTridentRenderer.INSTANCE.render(entity, stack, renderMode,
                leftHanded, matrices, vertexConsumers, light, overlay, model))) {
            info.cancel();
        }
    }
}
