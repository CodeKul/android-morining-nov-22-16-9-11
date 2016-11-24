package com.codekul.gird.db;

/**
 * Created by aniruddha on 23/11/16.
 */
public interface DbOperationListener<I> {

    void performOperation(I ... obj);
}
