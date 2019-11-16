package pri.zxx.learndemo.designmodels.adaptermodel;

import pri.zxx.learndemo.designmodels.adaptermodel.adpter.TypeAdapter;
import pri.zxx.learndemo.designmodels.adaptermodel.imp.AdvancePlayer;
import pri.zxx.learndemo.designmodels.adaptermodel.imp.MyPlayer;

public class Test {
    public static void main(String[] args) {
        TypeAdapter adapter = new TypeAdapter(new AdvancePlayer(), new MyPlayer());
        adapter.play("mp5");
        adapter.play("mp3");
        adapter.play("mp4");
        adapter.play("flac");
    }
}
