package net.froztigaming.fantasycraft.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.froztigaming.fantasycraft.entity.ElvenArrowEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ElvenArrowRenderer extends ProjectileEntityRenderer<ElvenArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("fantasycraft:textures/entity/elven_arrow.png");

    public ElvenArrowRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(ElvenArrowEntity elvenArrowEntity) {
        return TEXTURE;
    }
}
