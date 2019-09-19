package com.example.liguixiao.day00_2;

import java.util.List;

/**
 * Created by liguixiao on 2019/9/18.
 */

public class MainPersenter {

    private Persenter p;

    public MainPersenter(Persenter p) {
        this.p = p;
    }

    public boolean isAttach() {
        return p != null;
    }

    public void getModel() {
        MainModel mainModel = new MainModel();
        mainModel.getData(new Model() {
            @Override
            public void sendData(List<RootBeans.ResultsBean> results) {
                if (isAttach()){
                    p.sendData(results);
                }
            }
        });
    }

    public void detach() {
        p = null;
    }
}
