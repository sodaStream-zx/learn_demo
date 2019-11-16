package pri.zxx.learndemo.designmodels.adaptermodel.imp;

import pri.zxx.learndemo.designmodels.adaptermodel.interfaces.BasicMediaPlayer;

public class MyPlayer implements BasicMediaPlayer {

    @Override
    public void playMp3() {
        // TODO Auto-generated method stub
        System.out.println("解码完成，开始播放Mp3。。。。。");
    }

}
