package com.bearever.articlememento.memento;

import com.bearever.articlememento.model.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章的备忘录
 * Created by luoming on 2018/3/22.
 */

public class ArticleMemento {
    private List<Section> sectionList = new ArrayList<>();

    public ArticleMemento(ArticleOriginator originator) {
        sectionList.clear();
        for (Section section : originator.getSectionList()) {
            sectionList.add(section);
        }
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
