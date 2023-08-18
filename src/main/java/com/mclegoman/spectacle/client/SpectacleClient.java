/*
    Spectacle
    Author: MCLegoMan
    Github: https://github.com/MCLegoMan/Spectacle
    License: CC-BY 4.0
*/

package com.mclegoman.spectacle.client;

import com.mclegoman.spectacle.common.data.SpectacleData;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SpectacleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try {
            SpectacleData.LOGGER.info(SpectacleData.PREFIX + "Initializing {}", SpectacleData.ID);
        } catch (Exception error) {
            SpectacleData.LOGGER.error(SpectacleData.PREFIX + "Failed to initialize {}: {}", SpectacleData.ID, error);
        }
    }
}