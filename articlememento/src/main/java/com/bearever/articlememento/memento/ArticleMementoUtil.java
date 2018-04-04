package com.bearever.articlememento.memento;

import com.bearever.articlememento.model.Section;

import java.util.List;

/**
 * 文章编辑历史记录的工具类
 * Created by luoming on 2018/3/30.
 */

public class ArticleMementoUtil {
    private ArticleOriginator mArticleOriginator; //
    private ArticleCaretaker mArticleCaretaker; //

    public ArticleMementoUtil() {
        mArticleCaretaker = new ArticleCaretaker();
        mArticleOriginator = new ArticleOriginator();
    }

    /**
     * 添加段落
     *
     * @param section
     */
    public void addSection(Section section) {
        mArticleOriginator.getSectionList().add(section);
        mArticleCaretaker.saveMemento(mArticleOriginator.createMemento());
    }

    /**
     * 设置段落列表
     *
     * @param list
     */
    public void setSectionList(List<Section> list) {
        mArticleOriginator.setSectionList(list);
        mArticleCaretaker.saveMemento(mArticleOriginator.createMemento());
    }

    /**
     * undo
     *
     * @return
     */
    public ArticleMemento undo() {
        return mArticleCaretaker.undo();
    }

    /**
     * redo
     *
     * @return
     */
    public ArticleMemento redo() {
        return mArticleCaretaker.redo();
    }

}
