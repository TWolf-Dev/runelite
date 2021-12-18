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

    /** General Config Options **/
    @ConfigItem(
            position = 0,
            keyName = "voiceVolume",
            name = "Voice Volume",
            description = "Adjust speaking voice volume."
    )
    default int voiceVolumeConfig() { return 1; }

    @ConfigItem(
            position = 1,
            keyName = "voiceSpeed",
            name = "Voice Speed",
            description = "Adjust the speed at which the plugin reads dialogue text."
    )
    default VoiceSpeedEnum voiceRateConfig() {
        return VoiceSpeedEnum.NORMAL;
    }

    @ConfigItem(
            position = 2,
            keyName = "voicePitch",
            name = "Voice Pitch",
            description = "Adjust the pitch of reading voice"
    )
    default VoicePitchEnum voicePitchConfig(){
        return VoicePitchEnum.MEDIUM;
    }

    @ConfigItem(
            position = 3,
            keyName = "publicChatOption",
            name = "Read Public Chat",
            description = "Enable/Disable Public Chat TTS"
    )
    default boolean publicChatOption() {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "privateChat",
            name = "Read Private Messages",
            description = "Enable/Disable Private Chat TTS"
    )
    default boolean privateChat() {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "dialogueText",
            name = "Read Dialog w/ NPCs",
            description = "Enable/Disable Dialogue TTS"
    )
    default boolean dialogueText() {
        return true;
    }

    /** Secondary Public Chat Options **/
    @ConfigSection(
            position = 6,
            name = "Public Chat",
            description = "Settings for Public Chat",
            closedByDefault = true
    )
    String publicSection = "Public Chat";

    @ConfigItem(
            position = 8,
            keyName = "announceSender",
            name = "Announce Sender",
            description = "Prefixes the sender's name to the message.",
            section = publicSection
    )
    default boolean publicAnnounceSender() { return false; }

    @ConfigItem(
            position = 9,
            keyName = "readOnlyFriends",
            name = "Read Friend Messages Only",
            description = "Enable/Disable Only Reading Friend Messages TTS",
            section = publicSection
    )
    default boolean publicFriendsOnly() {
        return false;
    }


    /** Secondary Private Chat Options **/
    @ConfigSection(
            position = 10,
            name = "Private Messages",
            description = "Settings for private messages",
            closedByDefault = true
    )
    String privateSection = "Private Messages";

    @ConfigItem(
            position = 11,
            keyName = "notifyMessage",
            name = "Notification ONLY",
            description = "Disable other options and only announce msg type and sender.",
            section = privateSection
    )
    default boolean privateNotificationOnly() { return false; }

    @ConfigItem(
            position = 12,
            keyName = "announceSender",
            name = "Announce Sender",
            description = "Prefixes the sender's name to the message.",
            section = privateSection
    )
    default boolean privateAnnounceSender() { return false; }

    @ConfigItem(
            position = 13,
            keyName = "readOnlyFriends",
            name = "Read Friend Messages Only",
            description = "Enable/Disable Only Reading Friend Messages TTS",
            section = privateSection
    )
    default boolean privateFriendsOnly() {
        return false;
    }

    /** Secondary NPC Dialogue Options **/
    @ConfigSection(
            position = 14,
            name = "NPC/Quest Dialogue",
            description = "Settings for NPC/Quest Dialogue",
            closedByDefault = true
    )
    String npcSection = "NPC/Quest Dialogue";

    @ConfigItem(
            position = 15,
            keyName = "playerChoices",
            name = "Read Choice Options",
            description = "Enable/Disable Speech for player choices",
            section = npcSection
    )
    default boolean playerChoices() {
        return false;
    }

    @ConfigItem(
            position = 16,
            keyName = "readDialogNames",
            name = "Read Narrator Name",
            description = "Reads the name of the narrator.",
            section = npcSection
    )
    default boolean readNarratorName() { return false; }


    /** Future Options **/
    @ConfigSection(
            position = 20,
            name = "Clan Chat",
            description = "Settings for Clan Chat",
            closedByDefault = true
    )
    String ccSection = "Clan Chat";

    @ConfigSection(
            position = 21,
            name = "Game Chat",
            description = "Settings for game chat (i.e. game notifications)",
            closedByDefault = true
    )
    String gcSection = "Game Chat";

}

