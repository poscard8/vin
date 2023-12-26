package github.poscard8.vividitemnames.util;

import com.mojang.datafixers.util.Pair;
import github.poscard8.vividitemnames.VividItemNames;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.ByIdMap;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.IntFunction;

@OnlyIn(Dist.CLIENT)
public enum Enclosure {
    NONE(""),
    SQUARE_BRACKET("[", "]"),
    CURLY_BRACE("{", "}"),
    PIPE("|"),
    ANGLE_BRACKET("<", ">"),
    HYPHEN("-"),
    PLUS("+ ", " +"),
    PLUS_MINUS("± ", " ±"),
    CIRCLE("● ", " ●"),
    SQUARE("■ ", " ■"),
    STAR("✶ ", " ✶"),
    OBFUSCATED("A ", " A");

    public static final IntFunction<Enclosure> BY_ID = ByIdMap.continuous(Enclosure::ordinal, values(), ByIdMap.OutOfBoundsStrategy.WRAP);

    private final String translatable;
    private final String prefix;
    private final String suffix;

    Enclosure(String prefix) { this(prefix, prefix); }

    Enclosure(String prefix, String suffix) {
        this.translatable = "enclosure.vin." + this;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public static Enclosure byId(int i) { return BY_ID.apply(i); }

    public Pair<Component, Component> getComponents(Rarity rarity, boolean isItalic) {

        Style style;

        switch (rarity.name()) {
            default -> {
                Style style0 = rarity.getStyleModifier().apply(Style.EMPTY);

                if (VividItemNames.OPTIONS.otherItemEnclosureColor.get() != NameColor.DEFAULT) {
                    style0 = style0.withColor(VividItemNames.OPTIONS.otherItemEnclosureColor.get().get());
                } else if (VividItemNames.OPTIONS.otherItemColor.get() != NameColor.DEFAULT) {
                    style0 = style0.withColor(VividItemNames.OPTIONS.otherItemColor.get().get());
                }
                if (VividItemNames.OPTIONS.otherItemBold.get() != ThreeStateOption.DEFAULT) {
                    style0 = style0.withBold(VividItemNames.OPTIONS.otherItemBold.get().getBoolean());
                }
                if (VividItemNames.OPTIONS.otherItemItalic.get() != ThreeStateOption.DEFAULT) {
                    style0 = style0.withItalic(VividItemNames.OPTIONS.otherItemItalic.get().getBoolean());
                }

                style = style0.withUnderlined(false).withStrikethrough(false).withObfuscated(this == OBFUSCATED);
            }

            case "vividitemnames:common" -> style = Style.EMPTY
                    .withColor(VividItemNames.OPTIONS.commonItemEnclosureColor.get().get())
                    .withBold(VividItemNames.OPTIONS.commonItemBold.get())
                    .withItalic(VividItemNames.OPTIONS.commonItemItalic.get())
                    .withUnderlined(false)
                    .withStrikethrough(false)
                    .withObfuscated(this == OBFUSCATED);

            case "vividitemnames:uncommon" -> style = Style.EMPTY
                    .withColor(VividItemNames.OPTIONS.uncommonItemEnclosureColor.get().get())
                    .withBold(VividItemNames.OPTIONS.uncommonItemBold.get())
                    .withItalic(VividItemNames.OPTIONS.uncommonItemItalic.get())
                    .withUnderlined(false)
                    .withStrikethrough(false)
                    .withObfuscated(this == OBFUSCATED);

            case "vividitemnames:rare" -> style = Style.EMPTY
                    .withColor(VividItemNames.OPTIONS.rareItemEnclosureColor.get().get())
                    .withBold(VividItemNames.OPTIONS.rareItemBold.get())
                    .withItalic(VividItemNames.OPTIONS.rareItemItalic.get())
                    .withUnderlined(false)
                    .withStrikethrough(false)
                    .withObfuscated(this == OBFUSCATED);

            case "vividitemnames:epic" -> style = Style.EMPTY
                    .withColor(VividItemNames.OPTIONS.epicItemEnclosureColor.get().get())
                    .withBold(VividItemNames.OPTIONS.epicItemBold.get())
                    .withItalic(VividItemNames.OPTIONS.epicItemItalic.get())
                    .withUnderlined(false)
                    .withStrikethrough(false)
                    .withObfuscated(this == OBFUSCATED);
        }

        if (isItalic) { style = style.withItalic(true); }

        return Pair.of(Component.literal(prefix).withStyle(style), Component.literal(suffix).withStyle(style));
    }

    public Component getTranslatable() { return Component.translatable(translatable); }

    @Override
    public String toString() { return super.toString().toLowerCase(); }

}
