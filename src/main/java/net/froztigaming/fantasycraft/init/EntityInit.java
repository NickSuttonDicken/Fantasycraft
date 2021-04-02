package net.froztigaming.fantasycraft.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.froztigaming.fantasycraft.entity.TritonTridentEntity;
import net.froztigaming.fantasycraft.tools.prismarine.TritonTrident;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntityInit {

    private static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();

    public static final EntityType<TritonTridentEntity> TRITON_TRIDENT_ENTITY = register("triton_trident",
            createTrident(ItemInit.TRITON_TRIDENT));


    public static void registerEntities() {
        for (Identifier id : ENTITY_TYPES.keySet()) {
            Registry.register(Registry.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
        }
    }

    private static <T extends EntityType<?>> T register(String name, T type) {
        Identifier id = new Identifier("fantasycraft", name);
        ENTITY_TYPES.put(id, type);
        return type;
    }

    private static EntityType<TritonTridentEntity> createTrident(TritonTrident item) {
        return FabricEntityTypeBuilder
                .<TritonTridentEntity>create(SpawnGroup.MISC,
                        (entity, world) -> new TritonTridentEntity(entity, world, item))
                .dimensions(EntityDimensions.fixed(1F, 1F)).build();
    }
}
