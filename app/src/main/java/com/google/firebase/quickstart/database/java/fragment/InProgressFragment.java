package com.google.firebase.quickstart.database.java.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class InProgressFragment extends A_PostListFragment{
    public InProgressFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {

        return databaseReference.child("posts").orderByChild("progress").equalTo("처리중");
    }
}
