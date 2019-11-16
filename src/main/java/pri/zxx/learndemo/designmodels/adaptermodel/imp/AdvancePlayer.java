package pri.zxx.learndemo.designmodels.adaptermodel.imp;

import pri.zxx.learndemo.designmodels.adaptermodel.interfaces.AdvanceMediaPlayer;

public class AdvancePlayer implements AdvanceMediaPlayer {

    @Override
    public void playMp4() {
        // TODO Auto-generated method stub
        System.out.println("解码完成，开始播放Mp4......");
    }

    @Override
    public void playFlac() {
        // TODO Auto-generated method stub
        System.out.println("解码完成，开始播放Flac......");
    }

}
