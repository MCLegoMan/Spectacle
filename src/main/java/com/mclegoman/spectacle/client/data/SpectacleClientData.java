/*
    Spectacle
    Author: MCLegoMan
    Github: https://github.com/MCLegoMan/Spectacle
    License: CC-BY 4.0
*/

package com.mclegoman.spectacle.client.data;

import com.mclegoman.spectacle.common.data.SpectacleData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class SpectacleClientData {
    public static final MinecraftClient CLIENT = MinecraftClient.getInstance();
    public static Identifier getLogo() {
        return SpectacleData.IS_DEVELOPMENT ? getLogoType(true) : getLogoType(false);
    }
    private static Identifier getLogoType(boolean development) {
        return development ? new Identifier(SpectacleData.ID, ("textures/logo/normal/development.png")) : new Identifier(SpectacleData.ID, ("textures/logo/normal/release.png"));
    }
}