package com.example.uas_akb_10119289.base;

//09 Agustus 2022, 10119289, Dhifo Aksa Hermawan, IF07
public interface IPresenter<T extends IView, IView> {
    void onAttach(T view);
    void onDetach();
}
