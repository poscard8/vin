package github.poscard8.vividitemnames;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
@Mod(VividItemNames.ID)
public class VividItemNames {

    public static final String ID = "vividitemnames";
    private static final ModOptions MOD_OPTIONS = ModOptions.getInstance();

    public VividItemNames() {
    }

    public static Component getButtonComponent() {
        MutableComponent mutable = Component.literal("V");

        int num = new Random().nextInt(16);
        mutable.withStyle(NameColor.byId(num).get());
        return mutable;
    }

    public static Style getCommonStyle() {
        return Style.EMPTY
                .withColor(MOD_OPTIONS.commonItemColor.get().get())
                .withBold(MOD_OPTIONS.commonItemBold.get())
                .withItalic(MOD_OPTIONS.commonItemItalic.get())
                .withUnderlined(MOD_OPTIONS.commonItemUnderline.get())
                .withStrikethrough(MOD_OPTIONS.commonItemStrikethrough.get())
                .withObfuscated(MOD_OPTIONS.commonItemObfuscated.get());
    }

    public static Style getUncommonStyle() {
        return Style.EMPTY
                .withColor(MOD_OPTIONS.uncommonItemColor.get().get())
                .withBold(MOD_OPTIONS.uncommonItemBold.get())
                .withItalic(MOD_OPTIONS.uncommonItemItalic.get())
                .withUnderlined(MOD_OPTIONS.uncommonItemUnderline.get())
                .withStrikethrough(MOD_OPTIONS.uncommonItemStrikethrough.get())
                .withObfuscated(MOD_OPTIONS.uncommonItemObfuscated.get());
    }

    public static Style getRareStyle() {
        return Style.EMPTY
                .withColor(MOD_OPTIONS.rareItemColor.get().get())
                .withBold(MOD_OPTIONS.rareItemBold.get())
                .withItalic(MOD_OPTIONS.rareItemItalic.get())
                .withUnderlined(MOD_OPTIONS.rareItemUnderline.get())
                .withStrikethrough(MOD_OPTIONS.rareItemStrikethrough.get())
                .withObfuscated(MOD_OPTIONS.rareItemObfuscated.get());
    }

    public static Style getEpicStyle() {
        return Style.EMPTY
                .withColor(MOD_OPTIONS.epicItemColor.get().get())
                .withBold(MOD_OPTIONS.epicItemBold.get())
                .withItalic(MOD_OPTIONS.epicItemItalic.get())
                .withUnderlined(MOD_OPTIONS.epicItemUnderline.get())
                .withStrikethrough(MOD_OPTIONS.epicItemStrikethrough.get())
                .withObfuscated(MOD_OPTIONS.epicItemObfuscated.get());
    }

}
