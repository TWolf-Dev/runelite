package net.runelite.client.plugins.texttospeech;

import java.util.HashMap;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


@PluginDescriptor(
        name = "Text-To-Speech",
        description = "Convert dialogue boxes and chat text into speech!",
        tags = {"speech", "voice", "text-to-speech}"},
        loadWhenOutdated = true,
        enabledByDefault = false
)
public class TextToSpeechPlugin extends Plugin {
    @Inject
    private TextToSpeechConfig config;

    @Inject
    private Client client;

    @Inject
    private ChatMessageManager chatMessageManager;

    @Inject
    private SpeechProcessing speechProcessor;

    @Provides
    TextToSpeechConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TextToSpeechConfig.class);
    }

    @Subscribe
    public void onChatMessage(ChatMessage chatMessage)
    {
        MessageNode messageNode = chatMessage.getMessageNode();
        String finalMessage;
        speechProcessor = new SpeechProcessing();

        finalMessage = chatMessage.getMessage();

        //TODO Filter out own messages && Announce Player Names
        switch (chatMessage.getType())
        {
            case MODPRIVATECHAT:
            case PRIVATECHATOUT:
            case MODCHAT:
                return;
            case PRIVATECHAT:

            case PUBLICCHAT:
                if(!config.publicChatOption()) {
                    break;
                }else if(config.publicFriendsOnly()){
                    //Throw some logic to only read chats from Friends
                }else{
                    speechProcessor.processSpeech(finalMessage);
                }
            case FRIENDSCHAT:
            case CLAN_CHAT:
            case CLAN_GUEST_CHAT:
            case AUTOTYPER:
            case MODAUTOTYPER:
            case CONSOLE:
                break;
        }

        switch (config.voicePitchConfig()){
            case LOW:
                speechProcessor.setPitch(30);
                break;
            case MEDIUM:
                speechProcessor.setPitch(55);
                break;
            case HIGH:
                speechProcessor.setPitch(90);
                break;
        }

        switch(config.voiceRateConfig()){
            case SLOW:
                speechProcessor.setRate(75);
                break;
            case NORMAL:
                speechProcessor.setRate(190);
                break;
            case FAST:
                speechProcessor.setRate(300);
                break;
        }

    }
}
