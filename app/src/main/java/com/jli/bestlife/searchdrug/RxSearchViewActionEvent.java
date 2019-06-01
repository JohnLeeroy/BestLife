package com.jli.bestlife.searchdrug;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.jli.bestlife.searchdrug.RxSearchViewActionEvent.QUERY_CHANGE;
import static com.jli.bestlife.searchdrug.RxSearchViewActionEvent.SUBMIT;

@Retention(RetentionPolicy.SOURCE)
@IntDef({QUERY_CHANGE, SUBMIT})
public @interface RxSearchViewActionEvent {
    int QUERY_CHANGE = 1;
    int SUBMIT = 2;
}
