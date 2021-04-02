package net.froztigaming.fantasycraft.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.init.ItemInit;

@Config(name = FantasycraftMain.MOD_ID)
public class FantasycraftConfig extends PartitioningSerializer.GlobalData {

    public Metals METALS = new Metals();
    public BonusEffects BONUSEFFECTS = new BonusEffects();

    @Config(name = "metals")
    public static class Metals implements ConfigData
    {
        @Comment("\n"
                +"\n"
                + "***********************"
                +"\nBronze"
                +"\n***********************"
                +"\nEnables Bronze and Dwarven items")
        public boolean bronzeEnable = true;
        @Comment("Default: 10")
        public int bronzeVeinSize = 10;
        @Comment("Default: 0")
        public int bronzeMinLevel = 0;
        @Comment("Default: 256")
        public int bronzeMaxLevel = 256;
        @Comment("Default: 7")
        public int bronzePerChunk = 7;
        @Comment("\n"
                +"\n"
                + "***********************"
                +"\nSilver"
                +"\n***********************"
                +"\nEnables Silver and Elven items")
        public boolean silverEnable = true;
        @Comment("Default: 7")
        public int silverVeinSize = 7;
        @Comment("Default: 0")
        public int silverMinLevel = 0;
        @Comment("Default: 32")
        public int silverMaxLevel = 32;
        @Comment("Default: 2")
        public int silverPerChunk = 2;
        @Comment("\n"
                +"\n"
                + "***********************"
                +"\nPrismarine"
                +"\n***********************"
                +"\nEnables Prismarine Items")
        public boolean prismarineEnable = true;
        @Comment("\n"
                +"\n"
                + "***********************"
                +"\nMithril"
                +"\n***********************"
                +"\nEnables Mithril Items")
        public boolean mithrilEnable = true;
        @Comment("Default: 2")
        public int mithrilVeinSize = 2;
        @Comment("Default: 0")
        public int mithrilMinLevel = 0;
        @Comment("Default: 64")
        public int mithrilMaxLevel = 64;
        @Comment("Default: 7")
        public int mithrilPerChunk = 7;
    }

    @Config(name = "Bonus Effects")
    public static class BonusEffects implements ConfigData
    {
        @Comment("\n"
                +"\n"
                + "***********************"
                +"\nTool Effects"
                +"\n***********************"
                +"\nEnables Status Effects for Tool/Weapons")
        public boolean enableToolEffect = true;
        @Comment("\n"
                +"\n"
                + "***********************"
                +"\nArmor Set Bonus Effects"
                +"\n***********************"
                +"\nEnables Set Bonus Effects for Armors")
        public boolean enableArmorSetBonuses = true;
    }
}
