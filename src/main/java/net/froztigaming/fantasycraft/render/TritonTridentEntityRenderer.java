package net.froztigaming.fantasycraft.render;

import net.froztigaming.fantasycraft.entity.TritonTridentEntity;
import net.froztigaming.fantasycraft.entity.model.TritonTridentEntityModel;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class TritonTridentEntityRenderer extends EntityRenderer<TritonTridentEntity> {
    private static final Map<EntityType<?>, Identifier> TEXTURES = new HashMap<>();
    private final TritonTridentEntityModel model = new TritonTridentEntityModel();

    public TritonTridentEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public void render(TritonTridentEntity tritonTridentEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumerProvider,
                model.getLayer(this.getTexture(tritonTridentEntity)), false, tritonTridentEntity.enchantingGlint());
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, tritonTridentEntity.prevYaw, tritonTridentEntity.yaw) - 90.0F));
        matrixStack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, tritonTridentEntity.prevPitch, tritonTridentEntity.pitch) + 90.0F));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.scale(1.25F, -1.25F, 1.25F);
        matrixStack.translate(0.0D, -4.0D, 0.0D);
        matrixStack.pop();
        super.render(tritonTridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(TritonTridentEntity tritonTridentEntity) {
        return getTexture(tritonTridentEntity.getType());
    }

    public static Identifier getTexture(EntityType<?> type) {
        if (!TEXTURES.containsKey(type)) {
            TEXTURES.put(type,
                    new Identifier("fantasycraft", "textures/entity/" + Registry.ENTITY_TYPE.getId(type).getPath() + ".png"));
        }
        return TEXTURES.get(type);
    }
}
