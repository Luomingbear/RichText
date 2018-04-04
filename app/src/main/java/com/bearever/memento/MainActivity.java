package com.bearever.memento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bearever.articlememento.memento.ArticleMemento;
import com.bearever.articlememento.memento.ArticleMementoUtil;
import com.bearever.articlememento.model.Section;
import com.bearever.articlememento.richtext.OnRichTextChangeListener;
import com.bearever.articlememento.richtext.RichTextEditor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RichTextEditor mInputEt; //
    private ArticleMementoUtil mArticleMementoUtil = new ArticleMementoUtil();
    private List<String> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        images.add("http://h.hiphotos.baidu.com/image/pic/item/bf096b63f6246b6053915a7fe7f81a4c510fa21a.jpg");
        images.add("http://a.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3ce23db22389e45d688d43f20a6.jpg");
        images.add("http://h.hiphotos.baidu.com/image/pic/item/377adab44aed2e73ac116e278b01a18b86d6fac5.jpg");
        images.add("http://e.hiphotos.baidu.com/image/pic/item/0d338744ebf81a4c35f405c2db2a6059242da6f3.jpg");
    }

    private void initView() {
        mInputEt = (RichTextEditor) findViewById(R.id.input_et);
        mArticleMementoUtil.setSectionList(mInputEt.getContentSectionList());

        findViewById(R.id.undo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleMemento memento = mArticleMementoUtil.undo();
                Log.i(TAG, "onClick: undo:" + memento);
                if (memento != null) {
                    mInputEt.setContentByArticleMemento(memento);
                }
            }
        });

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = ((int) (Math.random() * 10)) % 4;
                mInputEt.addImageSection(images.get(i));
            }
        });

        findViewById(R.id.redo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleMemento memento = mArticleMementoUtil.redo();
                Log.i(TAG, "onClick: redo:" + memento);
                if (memento != null) {
                    mInputEt.setContentByArticleMemento(memento);
                }
            }
        });

        mInputEt.setOnRichTextChangeListener(new OnRichTextChangeListener() {
            @Override
            public void onChanged(List<Section> sectionList) {
                mArticleMementoUtil.setSectionList(sectionList);
            }
        });
    }


}
