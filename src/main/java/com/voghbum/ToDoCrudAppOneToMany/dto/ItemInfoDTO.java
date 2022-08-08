package com.voghbum.ToDoCrudAppOneToMany.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ItemInfoDTO {
    private String m_text;
    private LocalDateTime m_insertTime;
    private LocalDateTime m_lastUpdate;
    private boolean m_completed;

    public String getText() {
        return m_text;
    }

    public void setText(String text) {
        m_text = text;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getInsertTime() {
        return m_insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        m_insertTime = insertTime;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getLastUpdate() {
        return m_lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        m_lastUpdate = lastUpdate;
    }

    public boolean isCompleted() {
        return m_completed;
    }

    public void setCompleted(boolean completed) {
        m_completed = completed;
    }
}
