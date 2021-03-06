package net.froztigaming.fantasycraft.entity.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class TritonTridentEntityModel extends Model {
    private final ModelPart base = new ModelPart(32, 32, 0, 6);

    public TritonTridentEntityModel() {
        super(RenderLayer::getEntitySolid);
        base.addCuboid(-0.5F, 2.0F, -0.5F, 1.0F, 25.0F, 1.0F, 0.0F);
        ModelPart modelPart = new ModelPart(32, 32, 4, 0);
        modelPart.addCuboid(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 1.0F);
        base.addChild(modelPart);
        ModelPart modelPart2 = new ModelPart(32, 32, 4, 3);
        modelPart2.addCuboid(-2.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F);
        base.addChild(modelPart2);
        ModelPart modelPart3 = new ModelPart(32, 32, 0, 0);
        modelPart3.addCuboid(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F);
        base.addChild(modelPart3);
        ModelPart modelPart4 = new ModelPart(32, 32, 4, 3);
        modelPart4.mirror = true;
        modelPart4.addCuboid(1.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F);
        base.addChild(modelPart4);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
                       float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}

