package uk.quasarhusky.letitsnow;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LetItSnow extends JavaPlugin {

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();

        protocolManager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL,
                PacketType.Play.Server.MAP_CHUNK) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();

                int[] biomes = packet.getIntegerArrays().read(0);

                for(int i = 0; i < biomes.length; i ++) {
                    switch(biomes[i]) {
                        case 0:
                        case 10:
                        case 24:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                            biomes[i] = 10; break; // Frozen ocean

                        case 4:
                        case 5:
                        case 6:
                        case 20:
                        case 27:
                        case 29:
                        case 32:
                        case 34:
                        case 133:
                        case 155:
                        case 160:
                        case 162:
                            biomes[i] = 30; break; // Snowy Taiga

                        case 18:
                        case 19:
                        case 28:
                        case 33:
                        case 134:
                        case 156:
                        case 157:
                        case 161:
                            biomes[i] = 31; break; // Snowy Taiga Hills

                        case 7:
                            biomes[i] = 11; break; // Frozen River

                        case 16:
                        case 25:
                            biomes[i] = 26; break; // Snowy Beach

                        case 2:
                        case 8:
                        case 9:
                        case 12:
                        case 13:
                        case 17:
                        case 21:
                        case 22:
                        case 23:
                        case 26:
                        case 30:
                        case 31:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 127:
                        case 130:
                        case 140:
                        case 149:
                        case 151:
                        case 158:
                        case 163:
                        case 164:
                        case 165:
                        case 166:
                        case 167:
                        case 168:
                        case 169:
                        case 170:
                        case 171:
                        case 172:
                        case 173:
                        case 174:
                        case 175:
                            break;

                        case 129:
                        case 131:
                        case 132:
                        default:
                            biomes[i] = 12; break;
                    }
                }

                packet.getIntegerArrays().write(0, biomes);
            }

        });
    }

    @Override
    public void onDisable() {

    }

}
