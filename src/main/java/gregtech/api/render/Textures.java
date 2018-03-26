package gregtech.api.render;

import gregtech.api.GTValues;
import gregtech.api.util.GTLog;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

import static gregtech.api.render.OrientedOverlayRenderer.OverlayFace.*;

public class Textures {

    public static SimpleSidedRenderer STEAM_CASING_BRONZE = new SimpleSidedRenderer("casings/steam/bronze");
    public static SimpleSidedRenderer STEAM_CASING_STEEL = new SimpleSidedRenderer("casings/steam/steel");
    public static SimpleSidedRenderer[] VOLTAGE_CASINGS = new SimpleSidedRenderer[GTValues.V.length];

    public static OrientedOverlayRenderer COAL_BOILER_OVERLAY = new OrientedOverlayRenderer("generators/boiler/coal", FRONT);
    public static OrientedOverlayRenderer LAVA_BOILER_OVERLAY = new OrientedOverlayRenderer("generators/boiler/lava", FRONT);
    public static OrientedOverlayRenderer SOLAR_BOILER_OVERLAY = new OrientedOverlayRenderer("generators/boiler/solar", TOP);

    public static OrientedOverlayRenderer ALLOY_SMELTER_OVERLAY = new OrientedOverlayRenderer("machines/alloy_smelter", FRONT);
    public static OrientedOverlayRenderer FURNACE_OVERLAY = new OrientedOverlayRenderer("machines/furnace", FRONT);
    public static OrientedOverlayRenderer EXTRACTOR_OVERLAY = new OrientedOverlayRenderer("machines/extractor", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("machines/compressor", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer HAMMER_OVERLAY = new OrientedOverlayRenderer("machines/hammer", FRONT);
    public static OrientedOverlayRenderer MACERATOR_OVERLAY = new OrientedOverlayRenderer("machines/macerator", FRONT, TOP);

    static {
        for(int i = 0; i < VOLTAGE_CASINGS.length; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            VOLTAGE_CASINGS[i] = new SimpleSidedRenderer("casings/voltage/" + voltageName);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void register(TextureMap textureMap) {
        GTLog.logger.info("Loading meta tile entity texture sprites...");
        STEAM_CASING_BRONZE.registerSprites(textureMap);
        STEAM_CASING_STEEL.registerSprites(textureMap);
        Arrays.stream(VOLTAGE_CASINGS).forEach(c -> c.registerSprites(textureMap));

        COAL_BOILER_OVERLAY.registerSprites(textureMap);
        LAVA_BOILER_OVERLAY.registerSprites(textureMap);
        SOLAR_BOILER_OVERLAY.registerSprites(textureMap);
    }

}