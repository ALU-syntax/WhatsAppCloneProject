package com.example.android.whatsappcloneproject.interfaces;

import com.example.android.whatsappcloneproject.model.chat.Chats;

import java.util.List;

public interface OnReadChatCallBack {
    void onReadSuccess(List<Chats> list);
    void onReadFailed();
}
