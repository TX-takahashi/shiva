package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

abstract class SelectorBase implements Selector{

    private Selector.Listener mListener;
    private String mResult;

    @Override
    public void execute() {
        executeLocal();
    }

    @Override
    public void select() {
        if (mListener != null) {
            mListener.onTypeChanged(mResult);
        }
    }

    @Override
    public void registerListener(Selector.Listener listener) {
        checkArgument(listener != null, "Selector.Listener must not be null.");
        mListener = listener;
    }

    @Override
    public void unregisterListener() {
        mListener = null;
    }

    abstract void executeLocal();

    void setResult(String result) {
        mResult = result;
    }
}
