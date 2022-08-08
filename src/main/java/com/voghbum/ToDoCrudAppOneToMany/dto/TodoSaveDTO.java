package com.voghbum.ToDoCrudAppOneToMany.dto;

public class TodoSaveDTO {
    private long m_id;
    private String m_title;
    private String m_description;

    public String getTitle() {
        return m_title;
    }

    public void setTitle(String title) {
        m_title = title;
    }

    public String getDescription() {
        return m_description;
    }

    public long getId() {
        return m_id;
    }

    public void setDescription(String description) {
        m_description = description;
    }
}
