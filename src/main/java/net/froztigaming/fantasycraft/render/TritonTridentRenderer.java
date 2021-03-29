package net.froztigaming.fantasycraft.render;

import net.froztigaming.fantasycraft.entity.TritonTridentEntity;
import net.froztigaming.fantasycraft.entity.model.TritonTridentEntityModel;
import net.froztigaming.fantasycraft.tools.prismarine.TritonTrident;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;

public enum TritonTridentRenderer {
    INSTANCE;

    private final TritonTridentEntityModel tritonTridentEntityModel = new TritonTridentEntityModel();


    public boolean render(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded,
                          MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model) {
        if (renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND
                || renderMode == ModelTransformation.Mode.FIXED) {
            return false;
        }

        matrices.push();

        model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);

        if (entity != null && entity.isUsingItem() && entity.getActiveItem() == stack
                && (renderMode == ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND
                || renderMode == ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND)) {
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(0F));
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90F));
            matrices.translate(0.0D, -1.5D, 0.0D);
            matrices.scale(1.5f, -1.5f, -1.5f);
        } else if (renderMode != ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND
                && renderMode != ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) {
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(67.5F));
            matrices.translate(0.0D, 0.75D, 0.0D);
            matrices.scale(1.5F, 1.5F, 1.5F);
        } else {
            matrices.translate(0.0D, 0.35D, -0.13D);
        }

        matrices.scale(1.25F, -1.25F, -1.25F);
        VertexConsumer spear = ItemRenderer.getItemGlintConsumer(vertexConsumers, this.tritonTridentEntityModel.getLayer(
                TritonTridentEntityRenderer.getTexture(((TritonTrident) stack.getItem()).getType())), false, stack.hasGlint());
        this.tritonTridentEntityModel.render(matrices, spear, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
        return true;
    }
}
