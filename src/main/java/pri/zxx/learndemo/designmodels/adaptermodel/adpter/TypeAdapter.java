package pri.zxx.learndemo.designmodels.adaptermodel.adpter;

import pri.zxx.learndemo.designmodels.adaptermodel.interfaces.AdvanceMediaPlayer;
import pri.zxx.learndemo.designmodels.adaptermodel.interfaces.BasicMediaPlayer;

public class TypeAdapter {

    AdvanceMediaPlayer advanceMediaPlayer;
    BasicMediaPlayer basicMediaPlayer;

    public TypeAdapter(AdvanceMediaPlayer advanceMediaPlayer, BasicMediaPlayer basicMediaPlayer) {
        this.advanceMediaPlayer = advanceMediaPlayer;
        this.basicMediaPlayer = basicMediaPlayer;
    }

    public TypeAdapter() {
        super();
    }


    public void play(String fileType) {

        switch (fileType.toLowerCase()) {
            case "mp3":
                basicMediaPlayer.playMp3();
                break;
            case "mp4":
                advanceMediaPlayer.playMp4();
                break;
            case "flac":
                advanceMediaPlayer.playFlac();
                break;
            default:
                System.out.println("没有该格式解码器，无法播放");
                break;
        }
    }

}
