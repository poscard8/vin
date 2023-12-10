package github.poscard8.vividitemnames;

import com.mojang.serialization.Codec;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
public class ModOptions {

    private ModOptions() {
    }

    private static final ModOptions INSTANCE = new ModOptions();

    public static ModOptions getInstance() {
        return INSTANCE;
    }

    public final OptionInstance<NameColor> commonItemColor = itemColorOption(NameColor.WHITE);
    public final OptionInstance<Boolean> commonItemBold = OptionInstance.createBoolean("options.item_bold", false);
    public final OptionInstance<Boolean> commonItemItalic = OptionInstance.createBoolean("options.item_italic", false);
    public final OptionInstance<Boolean> commonItemUnderline = OptionInstance.createBoolean("options.item_underline", false);
    public final OptionInstance<Boolean> commonItemStrikethrough = OptionInstance.createBoolean("options.item_strikethrough", false);
    public final OptionInstance<Boolean> commonItemObfuscated = OptionInstance.createBoolean("options.item_obfuscated", false);

    public final OptionInstance<NameColor> uncommonItemColor = itemColorOption(NameColor.YELLOW);
    public final OptionInstance<Boolean> uncommonItemBold = OptionInstance.createBoolean("options.item_bold", false);
    public final OptionInstance<Boolean> uncommonItemItalic = OptionInstance.createBoolean("options.item_italic", false);
    public final OptionInstance<Boolean> uncommonItemUnderline = OptionInstance.createBoolean("options.item_underline", false);
    public final OptionInstance<Boolean> uncommonItemStrikethrough = OptionInstance.createBoolean("options.item_strikethrough", false);
    public final OptionInstance<Boolean> uncommonItemObfuscated = OptionInstance.createBoolean("options.item_obfuscated", false);

    public final OptionInstance<NameColor> rareItemColor = itemColorOption(NameColor.AQUA);
    public final OptionInstance<Boolean> rareItemBold = OptionInstance.createBoolean("options.item_bold", false);
    public final OptionInstance<Boolean> rareItemItalic = OptionInstance.createBoolean("options.item_italic", false);
    public final OptionInstance<Boolean> rareItemUnderline = OptionInstance.createBoolean("options.item_underline", false);
    public final OptionInstance<Boolean> rareItemStrikethrough = OptionInstance.createBoolean("options.item_strikethrough", false);
    public final OptionInstance<Boolean> rareItemObfuscated = OptionInstance.createBoolean("options.item_obfuscated", false);

    public final OptionInstance<NameColor> epicItemColor = itemColorOption(NameColor.MAGENTA);
    public final OptionInstance<Boolean> epicItemBold = OptionInstance.createBoolean("options.item_bold", false);
    public final OptionInstance<Boolean> epicItemItalic = OptionInstance.createBoolean("options.item_italic", false);
    public final OptionInstance<Boolean> epicItemUnderline = OptionInstance.createBoolean("options.item_underline", false);
    public final OptionInstance<Boolean> epicItemStrikethrough = OptionInstance.createBoolean("options.item_strikethrough", false);
    public final OptionInstance<Boolean> epicItemObfuscated = OptionInstance.createBoolean("options.item_obfuscated", false);

    private static OptionInstance<NameColor> itemColorOption(NameColor defaultValue) {
        return new OptionInstance<>("options.item_color", OptionInstance.noTooltip(),
                (component, nameColor) -> (Component.translatable(nameColor.toString())),
                new OptionInstance.Enum<>(Arrays.asList(NameColor.values()), Codec.INT.xmap(NameColor::byId, NameColor::ordinal)), defaultValue, nameColor -> {
        });
    }

    public OptionInstance<?>[] commonItemOptions() {
        return new OptionInstance<?>[]{commonItemColor, commonItemBold, commonItemItalic, commonItemUnderline, commonItemStrikethrough, commonItemObfuscated};
    }

    public OptionInstance<?>[] uncommonItemOptions() {
        return new OptionInstance<?>[]{uncommonItemColor, uncommonItemBold, uncommonItemItalic, uncommonItemUnderline, uncommonItemStrikethrough, uncommonItemObfuscated};
    }

    public OptionInstance<?>[] rareItemOptions() {
        return new OptionInstance<?>[]{rareItemColor, rareItemBold, rareItemItalic, rareItemUnderline, rareItemStrikethrough, rareItemObfuscated};
    }

    public OptionInstance<?>[] epicItemOptions() {
        return new OptionInstance<?>[]{epicItemColor, epicItemBold, epicItemItalic, epicItemUnderline, epicItemStrikethrough, epicItemObfuscated};
    }

}
