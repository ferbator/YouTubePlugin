package com.ferbator.youtubeplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class YouTubeAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        YouTubeForm form = new YouTubeForm();
        form.setSize(500, 600);
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
