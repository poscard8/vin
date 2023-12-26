package github.poscard8.vividitemnames;

import com.mojang.serialization.Codec;
import github.poscard8.vividitemnames.util.Enclosure;
import github.poscard8.vividitemnames.util.NameColor;
import github.poscard8.vividitemnames.util.ThreeStateOption;
import net.minecraft.client.OptionInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
public class VividItemNamesOptions {

    private VividItemNamesOptions() {
    }

    private static final VividItemNamesOptions INSTANCE = new VividItemNamesOptions();

    public static VividItemNamesOptions getInstance() {
        return INSTANCE;
    }

    public final OptionInstance<NameColor> commonItemColor = colorOption(NameColor.WHITE, false);
    public final OptionInstance<Boolean> commonItemBold = OptionInstance.createBoolean("options.vin.item_bold", false);
    public final OptionInstance<Boolean> commonItemItalic = OptionInstance.createBoolean("options.vin.item_italic", false);
    public final OptionInstance<Boolean> commonItemUnderline = OptionInstance.createBoolean("options.vin.item_underline", false);
    public final OptionInstance<Boolean> commonItemStrikethrough = OptionInstance.createBoolean("options.vin.item_strikethrough", false);
    public final OptionInstance<Boolean> commonItemObfuscated = OptionInstance.createBoolean("options.vin.item_obfuscated", false);
    public final OptionInstance<Enclosure> commonItemEnclosure = enclosureOption();
    public final OptionInstance<NameColor> commonItemEnclosureColor = colorOption(NameColor.WHITE, true);

    public final OptionInstance<NameColor> uncommonItemColor = colorOption(NameColor.YELLOW, false);
    public final OptionInstance<Boolean> uncommonItemBold = OptionInstance.createBoolean("options.vin.item_bold", false);
    public final OptionInstance<Boolean> uncommonItemItalic = OptionInstance.createBoolean("options.vin.item_italic", false);
    public final OptionInstance<Boolean> uncommonItemUnderline = OptionInstance.createBoolean("options.vin.item_underline", false);
    public final OptionInstance<Boolean> uncommonItemStrikethrough = OptionInstance.createBoolean("options.vin.item_strikethrough", false);
    public final OptionInstance<Boolean> uncommonItemObfuscated = OptionInstance.createBoolean("options.vin.item_obfuscated", false);
    public final OptionInstance<Enclosure> uncommonItemEnclosure = enclosureOption();
    public final OptionInstance<NameColor> uncommonItemEnclosureColor = colorOption(NameColor.YELLOW, true);

    public final OptionInstance<NameColor> rareItemColor = colorOption(NameColor.AQUA, false);
    public final OptionInstance<Boolean> rareItemBold = OptionInstance.createBoolean("options.vin.item_bold", false);
    public final OptionInstance<Boolean> rareItemItalic = OptionInstance.createBoolean("options.vin.item_italic", false);
    public final OptionInstance<Boolean> rareItemUnderline = OptionInstance.createBoolean("options.vin.item_underline", false);
    public final OptionInstance<Boolean> rareItemStrikethrough = OptionInstance.createBoolean("options.vin.item_strikethrough", false);
    public final OptionInstance<Boolean> rareItemObfuscated = OptionInstance.createBoolean("options.vin.item_obfuscated", false);
    public final OptionInstance<Enclosure> rareItemEnclosure = enclosureOption();
    public final OptionInstance<NameColor> rareItemEnclosureColor = colorOption(NameColor.AQUA, true);

    public final OptionInstance<NameColor> epicItemColor = colorOption(NameColor.MAGENTA, false);
    public final OptionInstance<Boolean> epicItemBold = OptionInstance.createBoolean("options.vin.item_bold", false);
    public final OptionInstance<Boolean> epicItemItalic = OptionInstance.createBoolean("options.vin.item_italic", false);
    public final OptionInstance<Boolean> epicItemUnderline = OptionInstance.createBoolean("options.vin.item_underline", false);
    public final OptionInstance<Boolean> epicItemStrikethrough = OptionInstance.createBoolean("options.vin.item_strikethrough", false);
    public final OptionInstance<Boolean> epicItemObfuscated = OptionInstance.createBoolean("options.vin.item_obfuscated", false);
    public final OptionInstance<Enclosure> epicItemEnclosure = enclosureOption();
    public final OptionInstance<NameColor> epicItemEnclosureColor = colorOption(NameColor.MAGENTA, true);

    public final OptionInstance<NameColor> otherItemColor = otherItemColorOption(false);
    public final OptionInstance<ThreeStateOption> otherItemBold = otherItemStyleOption("bold");
    public final OptionInstance<ThreeStateOption> otherItemItalic = otherItemStyleOption("italic");
    public final OptionInstance<ThreeStateOption> otherItemUnderline = otherItemStyleOption("underline");
    public final OptionInstance<ThreeStateOption> otherItemStrikethrough = otherItemStyleOption("strikethrough");
    public final OptionInstance<ThreeStateOption> otherItemObfuscated = otherItemStyleOption("obfuscated");
    public final OptionInstance<Enclosure> otherItemEnclosure = enclosureOption();
    public final OptionInstance<NameColor> otherItemEnclosureColor = otherItemColorOption(true);

    public OptionInstance<?>[] commonItemOptions() {
        return new OptionInstance<?>[]{commonItemColor, commonItemBold, commonItemItalic, commonItemUnderline, commonItemStrikethrough, commonItemObfuscated, commonItemEnclosure, commonItemEnclosureColor};
    }

    public OptionInstance<?>[] uncommonItemOptions() {
        return new OptionInstance<?>[]{uncommonItemColor, uncommonItemBold, uncommonItemItalic, uncommonItemUnderline, uncommonItemStrikethrough, uncommonItemObfuscated, uncommonItemEnclosure, uncommonItemEnclosureColor};
    }

    public OptionInstance<?>[] rareItemOptions() {
        return new OptionInstance<?>[]{rareItemColor, rareItemBold, rareItemItalic, rareItemUnderline, rareItemStrikethrough, rareItemObfuscated, rareItemEnclosure, rareItemEnclosureColor};
    }

    public OptionInstance<?>[] epicItemOptions() {
        return new OptionInstance<?>[]{epicItemColor, epicItemBold, epicItemItalic, epicItemUnderline, epicItemStrikethrough, epicItemObfuscated, epicItemEnclosure, epicItemEnclosureColor};
    }

    public OptionInstance<?>[] otherItemOptions() {
        return new OptionInstance<?>[]{otherItemColor, otherItemBold, otherItemItalic, otherItemUnderline, otherItemStrikethrough, otherItemObfuscated, otherItemEnclosure, otherItemEnclosureColor};
    }

    private static OptionInstance<NameColor> colorOption(NameColor defaultValue, boolean isEnclosure) {
        String identifier = isEnclosure ? "options.vin.item_enclosure_color" : "options.vin.item_color";

        return new OptionInstance<>(identifier, OptionInstance.noTooltip(),
                (component, nameColor) -> (nameColor.getTranslatable()),
                new OptionInstance.Enum<>(Arrays.asList(NameColor.nonDefaultValues()), Codec.INT.xmap(NameColor::byId, NameColor::ordinal)), defaultValue, nameColor -> {
        });
    }

    private static OptionInstance<NameColor> otherItemColorOption(boolean isEnclosure) {
        String identifier = isEnclosure ? "options.vin.item_enclosure_color" : "options.vin.item_color";

        return new OptionInstance<>(identifier, OptionInstance.noTooltip(),
                (component, nameColor) -> (nameColor.getTranslatable()),
                new OptionInstance.Enum<>(Arrays.asList(NameColor.values()), Codec.INT.xmap(NameColor::byIdWithDefault, NameColor::ordinal)), NameColor.DEFAULT, nameColor -> {
        });
    }

    private static OptionInstance<ThreeStateOption> otherItemStyleOption(String identifier) {
        return new OptionInstance<>("options.vin.item_" + identifier, OptionInstance.noTooltip(),
                (component, option) -> (option.getTranslatable()),
                new OptionInstance.Enum<>(Arrays.asList(ThreeStateOption.values()), Codec.INT.xmap(ThreeStateOption::byId, ThreeStateOption::ordinal)), ThreeStateOption.DEFAULT, option -> {
        });
    }

    private static OptionInstance<Enclosure> enclosureOption() {
        return new OptionInstance<>("options.vin.item_enclosure", OptionInstance.noTooltip(),
                (component, enclosure) -> (enclosure.getTranslatable()),
                new OptionInstance.Enum<>(Arrays.asList(Enclosure.values()), Codec.INT.xmap(Enclosure::byId, Enclosure::ordinal)), Enclosure.NONE, enclosure -> {
        });
    }

}
