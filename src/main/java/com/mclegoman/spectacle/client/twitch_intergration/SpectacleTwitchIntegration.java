/*
    Spectacle
    Author: MCLegoMan
    Github: https://github.com/MCLegoMan/Spectacle
    License: CC-BY 4.0
*/

package com.mclegoman.spectacle.client.twitch_intergration;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.mclegoman.spectacle.client.config.SpectacleConfig;
import com.mclegoman.spectacle.common.data.SpectacleData;
import com.mclegoman.spectacle.common.util.SpectacleLogType;

public class SpectacleTwitchIntegration {
    public static TwitchClient TWITCH_CLIENT;
    public static void init() {
        try {
            start();
        } catch (Exception error) {
            SpectacleData.addLog(SpectacleLogType.ERROR, "(SpectacleTwitchIntegration) Failed to initialize: " + error);
        }
    }
    public static void refresh() {
        try {
            try {
                TWITCH_CLIENT.close();
            } catch (Exception ignored) {}
            start();
        } catch (Exception error) {
            SpectacleData.addLog(SpectacleLogType.ERROR, "(SpectacleTwitchIntegration) Failed to refresh: " + error);
        }
    }
    private static void start() {
        try {
            TWITCH_CLIENT = TwitchClientBuilder.builder()
                    .withEnableHelix(true)
                    .withEnablePubSub(true)
                    .build();
            join();
        } catch (Exception error) {
            SpectacleData.addLog(SpectacleLogType.ERROR, "(SpectacleTwitchIntegration) Failed to start: " + error);
        }
    }
    private static void join() {
        try {
            if (!TWITCH_CLIENT.getChat().isChannelJoined(SpectacleConfig.CHANNEL)) TWITCH_CLIENT.getChat().joinChannel(SpectacleConfig.CHANNEL);
        } catch (Exception error) {
            SpectacleData.addLog(SpectacleLogType.ERROR, "(SpectacleTwitchIntegration) Failed to join channel " + SpectacleConfig.CHANNEL + ": " + error);
        }
    }
}