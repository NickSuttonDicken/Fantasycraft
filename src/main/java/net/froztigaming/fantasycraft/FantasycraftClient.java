package net.froztigaming.fantasycraft;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.froztigaming.fantasycraft.register.Registration;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FantasycraftClient {

    public static void registerBow() {
        Identifier pull = new Identifier("pull");
        FabricModelPredicateProviderRegistry.register(Registration.ELVEN_BOW, pull, ModelPredicateProviderRegistry.get(Items.BOW, pull));
        Identifier pulling = new Identifier("pulling");
        FabricModelPredicateProviderRegistry.register(Registration.ELVEN_BOW, pulling, ModelPredicateProviderRegistry.get(Items.BOW, pulling));
    }


}
