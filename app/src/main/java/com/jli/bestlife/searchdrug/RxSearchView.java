package com.jli.bestlife.searchdrug;

import androidx.appcompat.widget.SearchView;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

public class RxSearchView {
    public static Observable<RxSearchActionEvent> onQueryActions(@NonNull final SearchView searchView) {
        final PublishSubject<RxSearchActionEvent> actionSubject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                actionSubject.onNext(new RxSearchActionEvent(RxSearchViewActionEvent.SUBMIT, query));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                actionSubject.onNext(new RxSearchActionEvent(RxSearchViewActionEvent.QUERY_CHANGE, query));
                return true;
            }
        });

        return actionSubject;
    }


    public static class RxSearchActionEvent {

        private final @RxSearchViewActionEvent
        int type;
        private final String text;

        public RxSearchActionEvent(int type, String text) {
            this.type = type;
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public String getText() {
            return text;
        }
    }
}
