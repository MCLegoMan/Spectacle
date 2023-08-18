/*
    Spectacle
    Author: MCLegoMan
    Github: https://github.com/MCLegoMan/Spectacle
    License: CC-BY 4.0
*/

package com.mclegoman.spectacle.client;

import com.mclegoman.spectacle.client.twitch_intergration.SpectacleTwitchIntegration;
import com.mclegoman.spectacle.common.data.SpectacleData;
import com.mclegoman.spectacle.common.util.SpectacleLogType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SpectacleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try {
            SpectacleData.addLog(SpectacleLogType.INFO, "Initializing " + SpectacleData.ID);
            SpectacleTwitchIntegration.init();
        } catch (Exception error) {
            SpectacleData.addLog(SpectacleLogType.ERROR, "(SpectacleClient) Failed to initialize: " + error);
        }
    }
}