package com.voghbum.ToDoCrudAppOneToMany.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TodoInfoDTO {
    private long m_id;
    private String m_title;
    private String m_description;
    private LocalDateTime m_insertTime;
    private boolean m_completed;

    public long getId() {
        return m_id;
    }

    public void setId(long id) {
        m_id = id;
    }

    public String getTitle() {
        return m_title;
    }

    public void setTitle(String title) {
        m_title = title;
    }

    public String getDescription() {
        return m_description;
    }

    public void setDescription(String description) {
        m_description = description;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    // @JsonProperty("insert time")
    public LocalDateTime getInsertTime() {
        return m_insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        m_insertTime = insertTime;
    }


    public boolean isCompleted() {
        return m_completed;
    }

    public void setCompleted(boolean completed) {
        m_completed = completed;
    }
}
