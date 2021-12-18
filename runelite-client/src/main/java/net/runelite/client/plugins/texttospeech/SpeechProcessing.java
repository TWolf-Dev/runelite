package net.runelite.client.plugins.texttospeech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.inject.Inject;

public class SpeechProcessing {
    private int rate = 30;
    private int pitch = 30;
    private float volume = 0.8f;
    private String senderName = "";

    @Inject
    private TextToSpeechConfig config;

    public void setString(String senderName){
        this.senderName = senderName;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
    public void setPitch(int pitch){
        this.pitch = pitch;
    }
    public void setVolume(float volume){
        this.volume = volume;
    }

    public String getMessage(){
        return this.senderName;
    }
    public int getRate(){
        return this.rate;
    }
    public int getPitch(){
        return this.pitch;
    }
    public float getVolume(){
        return this.volume;
    }


    public void processSpeech(String message){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        voice = VoiceManager.getInstance().getVoice("kevin16");
        //Create seperate thread for TTS
        new Thread(() -> {
            if(voice != null){
                voice.allocate();
            }
            try{
                voice.setRate(getRate());
                voice.setPitch(getPitch());
                voice.setVolume(getVolume());
                voice.speak(message);
            }catch(Exception e){
                e.printStackTrace();
            }
        }).start();

    }


}
