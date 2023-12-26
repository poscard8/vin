package github.poscard8.vividitemnames.util;


import com.mojang.datafixers.util.Pair;
import github.poscard8.vividitemnames.VividItemNames;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
import java.util.function.UnaryOperator;

@OnlyIn(Dist.CLIENT)
public abstract class VividItemNamesUtils {

    public static Rarity changeRarity(Rarity rarity) {

        Map<Rarity, Rarity> map = Map.of(
                Rarity.COMMON, Rarities.COMMON, Rarity.UNCOMMON, Rarities.UNCOMMON,
                Rarity.RARE, Rarities.RARE, Rarity.EPIC, Rarities.EPIC
        );

        if (map.containsKey(rarity)) {
            return map.get(rarity);
        } else {
            return processOtherItems(rarity);
        }
    }

    public static Component wrapInEnclosure(Component component, Rarity rarity) { return wrapInEnclosure(component, rarity, false); }

    public static Component wrapInEnclosure(Component component, Rarity rarity, boolean isItalic) {
        Pair<Component, Component> components;

        switch (rarity.name()) {
            default -> components = VividItemNames.OPTIONS.otherItemEnclosure.get().getComponents(rarity, isItalic);
            case "vividitemnames:common" -> components = VividItemNames.OPTIONS.commonItemEnclosure.get().getComponents(rarity, isItalic);
            case "vividitemnames:uncommon" -> components = VividItemNames.OPTIONS.uncommonItemEnclosure.get().getComponents(rarity, isItalic);
            case "vividitemnames:rare" -> components = VividItemNames.OPTIONS.rareItemEnclosure.get().getComponents(rarity, isItalic);
            case "vividitemnames:epic" -> components = VividItemNames.OPTIONS.epicItemEnclosure.get().getComponents(rarity, isItalic);
        }

        return components.getFirst().copy().append(component).append(components.getSecond());
    }

    public static Rarity processOtherItems(Rarity rarity) {

        String name;
        if (rarity.name().contains(":")) {
            int index = rarity.name().indexOf(":");
            name = VividItemNames.ID + rarity.name().substring(index);
        } else {
            name = VividItemNames.ID + ":" + rarity.name();
        }

        UnaryOperator<Style> operator = style -> {
            Style style0 = rarity.getStyleModifier().apply(Style.EMPTY);

            if (VividItemNames.OPTIONS.otherItemColor.get() != NameColor.DEFAULT) {
                style0 = style0.withColor(VividItemNames.OPTIONS.otherItemColor.get().get());
            }
            if (VividItemNames.OPTIONS.otherItemBold.get() != ThreeStateOption.DEFAULT) {
                style0 = style0.withBold(VividItemNames.OPTIONS.otherItemBold.get().getBoolean());
            }
            if (VividItemNames.OPTIONS.otherItemItalic.get() != ThreeStateOption.DEFAULT) {
                style0 = style0.withItalic(VividItemNames.OPTIONS.otherItemItalic.get().getBoolean());
            }
            if (VividItemNames.OPTIONS.otherItemUnderline.get() != ThreeStateOption.DEFAULT) {
                style0 = style0.withUnderlined(VividItemNames.OPTIONS.otherItemUnderline.get().getBoolean());
            }
            if (VividItemNames.OPTIONS.otherItemStrikethrough.get() != ThreeStateOption.DEFAULT) {
                style0 = style0.withStrikethrough(VividItemNames.OPTIONS.otherItemStrikethrough.get().getBoolean());
            }
            if (VividItemNames.OPTIONS.otherItemObfuscated.get() != ThreeStateOption.DEFAULT) {
                style0 = style0.withObfuscated(VividItemNames.OPTIONS.otherItemObfuscated.get().getBoolean());
            }
            return style0;
        };

        return Rarity.create(name, operator);
    }

    public static Style getCommonStyle() {
        return Style.EMPTY
                .withColor(VividItemNames.OPTIONS.commonItemColor.get().get())
                .withBold(VividItemNames.OPTIONS.commonItemBold.get())
                .withItalic(VividItemNames.OPTIONS.commonItemItalic.get())
                .withUnderlined(VividItemNames.OPTIONS.commonItemUnderline.get())
                .withStrikethrough(VividItemNames.OPTIONS.commonItemStrikethrough.get())
                .withObfuscated(VividItemNames.OPTIONS.commonItemObfuscated.get());
    }

    public static Style getUncommonStyle() {
        return Style.EMPTY
                .withColor(VividItemNames.OPTIONS.uncommonItemColor.get().get())
                .withBold(VividItemNames.OPTIONS.uncommonItemBold.get())
                .withItalic(VividItemNames.OPTIONS.uncommonItemItalic.get())
                .withUnderlined(VividItemNames.OPTIONS.uncommonItemUnderline.get())
                .withStrikethrough(VividItemNames.OPTIONS.uncommonItemStrikethrough.get())
                .withObfuscated(VividItemNames.OPTIONS.uncommonItemObfuscated.get());
    }

    public static Style getRareStyle() {
        return Style.EMPTY
                .withColor(VividItemNames.OPTIONS.rareItemColor.get().get())
                .withBold(VividItemNames.OPTIONS.rareItemBold.get())
                .withItalic(VividItemNames.OPTIONS.rareItemItalic.get())
                .withUnderlined(VividItemNames.OPTIONS.rareItemUnderline.get())
                .withStrikethrough(VividItemNames.OPTIONS.rareItemStrikethrough.get())
                .withObfuscated(VividItemNames.OPTIONS.rareItemObfuscated.get());
    }

    public static Style getEpicStyle() {
        return Style.EMPTY
                .withColor(VividItemNames.OPTIONS.epicItemColor.get().get())
                .withBold(VividItemNames.OPTIONS.epicItemBold.get())
                .withItalic(VividItemNames.OPTIONS.epicItemItalic.get())
                .withUnderlined(VividItemNames.OPTIONS.epicItemUnderline.get())
                .withStrikethrough(VividItemNames.OPTIONS.epicItemStrikethrough.get())
                .withObfuscated(VividItemNames.OPTIONS.epicItemObfuscated.get());
    }

    public static Style getOtherStyle() {
        return Style.EMPTY
                .withColor(VividItemNames.OPTIONS.otherItemColor.get().get())
                .withBold(VividItemNames.OPTIONS.otherItemBold.get().getBoolean())
                .withItalic(VividItemNames.OPTIONS.otherItemItalic.get().getBoolean())
                .withUnderlined(VividItemNames.OPTIONS.otherItemUnderline.get().getBoolean())
                .withStrikethrough(VividItemNames.OPTIONS.otherItemStrikethrough.get().getBoolean())
                .withObfuscated(VividItemNames.OPTIONS.otherItemObfuscated.get().getBoolean());
    }

    public static final class Rarities {

        public static final Rarity COMMON = Rarity.create("vividitemnames:common", style -> VividItemNamesUtils.getCommonStyle());
        public static final Rarity UNCOMMON = Rarity.create("vividitemnames:uncommon", style -> VividItemNamesUtils.getUncommonStyle());
        public static final Rarity RARE = Rarity.create("vividitemnames:rare", style -> VividItemNamesUtils.getRareStyle());
        public static final Rarity EPIC = Rarity.create("vividitemnames:epic", style -> VividItemNamesUtils.getEpicStyle());
        public static final Rarity PLACEHOLDER = Rarity.create("vividitemnames:placeholder", style -> Style.EMPTY);

    }

}
