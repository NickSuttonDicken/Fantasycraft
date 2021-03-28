package net.froztigaming.fantasycraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.froztigaming.fantasycraft.init.ItemInit;
import net.froztigaming.fantasycraft.render.ElvenArrowRenderer;
import net.froztigaming.fantasycraft.render.EntitySpawnPacket;
import net.froztigaming.fantasycraft.render.TritonTridentRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class FantasycraftClient implements ClientModInitializer {



    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ItemInit.ELVEN_ARROW_ENTITY_TYPE, (dispatcher, context) ->
                new ElvenArrowRenderer(dispatcher));

        BuiltinItemRendererRegistry.INSTANCE.register(ItemInit.TRITON_TRIDENT, TritonTridentRenderer::render);

        registerBow();
        registerTrident();
        receiveEntityPacket();
    }

    public static void registerBow() {
        Identifier pull = new Identifier("pull");
        FabricModelPredicateProviderRegistry.register(ItemInit.ELVEN_BOW, pull, ModelPredicateProviderRegistry.get(Items.BOW, pull));
        Identifier pulling = new Identifier("pulling");
        FabricModelPredicateProviderRegistry.register(ItemInit.ELVEN_BOW, pulling, ModelPredicateProviderRegistry.get(Items.BOW, pulling));
    }

    public static void registerTrident()
    {
        FabricModelPredicateProviderRegistry.register(ItemInit.TRITON_TRIDENT, new Identifier("throwing"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(FantasycraftMain.PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.pitch = pitch;
                e.yaw = yaw;
                e.setEntityId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }




}
