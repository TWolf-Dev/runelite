package net.runelite.client.plugins.texttospeech;

// Mandatory imports
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("texttospeech")
public interface TextToSpeechConfig extends Config {

    enum VoiceSpeedEnum {
        SLOW,
        NORMAL,
        FAST
    }
    enum VoicePitchEnum{
        LOW,
        MEDIUM,
        HIGH
    }

    @ConfigItem(
            position = 0,
            keyName = "voiceSpeed",
            name = "Voice Speed",
            description = "Adjust the speed at which the plugin reads dialogue text."
    )
    default VoiceSpeedEnum voiceRateConfig() {
        return VoiceSpeedEnum.NORMAL;
    }

    @ConfigItem(
            position = 1,
            keyName = "voicePitch",
            name = "Voice Pitch",
            description = "Adjust the pitch of reading voice"
    )
    default VoicePitchEnum voicePitchConfig(){
        return VoicePitchEnum.MEDIUM;
    }

    //TODO Add Volume Controls
    /*
    @ConfigItem(
            position = 2,
            keyName = "voiceVolume",
            name = "Volume (1-10)",
            description = "Adjust speech volume."
    )
    default int voiceVolume() { return 5; }*/

    @ConfigItem(
            position = 3,
            keyName = "dialogueText",
            name = "Read NPC/Quest Dialogues",
            description = "Enable/Disable Dialogue TTS"
    )
    default boolean dialogueText() {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "privateChat",
            name = "Read Private Chat Messages",
            description = "Enable/Disable Private Chat TTS"
    )
    default boolean privateChat() {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "readOnlyFriends",
            name = "Read Friend Messages Only",
            description = "Enable/Disable Only Reading Friend Messages TTS"
    )
    default boolean readOnlyFriends() {
        return false;
    }

    @ConfigSection(
            position = 6,
            name = "NPC/Quest Dialogue",
            description = "Settings for NPC/Quest Dialogue",
            closedByDefault = true
    )
    String npcSection = "NPC/Quest Dialogue";

    @ConfigSection(
            position = 7,
            name = "Private Messages",
            description = "Settings for private messages",
            closedByDefault = true
    )
    String pmSection = "Private Messages";

    @ConfigSection(
            position = 8,
            name = "Clan Chat",
            description = "Settings for Clan Chat",
            closedByDefault = true
    )
    String ccSection = "Clan Chat";

    @ConfigSection(
            position = 9,
            name = "Public Chat",
            description = "Settings for Public Chat",
            closedByDefault = true
    )
    String publicSection = "Public Chat";

    @ConfigSection(
            position = 10,
            name = "Game Chat",
            description = "Settings for game chat (i.e. game notifications)",
            closedByDefault = true
    )
    String gcSection = "Game Chat";


    // NPC/Quest Dialogue Section Options
    @ConfigItem(
            keyName = "playerChoices",
            name = "Read Choice Options",
            description = "Enable/Disable Speech for player choices",
            section = npcSection
    )
    default boolean playerChoices() {
        return true;
    }

    //Private Chat Options
    @ConfigItem(
            keyName = "announcePlayerName",
            name = "Announce Sender's Name",
            description = "Enable/Disable Announcing Sender Names",
            section = pmSection
    )
    default boolean announcePlayerName() {
        return true;
    }

    //Public Chat Options
    @ConfigItem(
            keyName = "publicChatOption",
            name = "Read Public Chat",
            description = "Enable/Disable Public Chat TTS",
            section = publicSection
    )
    default boolean publicChatOption() {
        return true;
    }
}

