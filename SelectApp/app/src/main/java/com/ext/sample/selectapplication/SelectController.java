package com.ext.sample.selectapplication;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

class SelectController {

    private SelectJudge mSelectJudge;

    private boolean mIsEffort;
    private boolean mIsRichIdea;
    private boolean mIsOwnPace;
    private boolean mIsKeepPromise;
    private boolean mIsEmotional;
    private boolean mIsHighExpectation;
    private Listener mListener;

    private boolean mIsInitialized;

    interface Listener {
        void onResultChanged(String result);
    }

    SelectController(@NonNull Listener listener) {
        checkArgument(listener != null, "Listener must not be null.");
        mListener = listener;
    }

    void init() {
        mSelectJudge = SelectJudgeFactory.create(mStateGettable);
        mIsInitialized = true;
    }

    void executeCreate() {
        checkState(mIsInitialized, "Initialized is not initialized yet.");

        Selector result = mSelectJudge.create();
        if (result != null) {
            result.execute();
            result.registerListener(mSelectorListener);
            result.select();
            result.unregisterListener();
        }
    }

    void destroy() {
        if (mListener != null) {
            mListener = null;
        }
        mIsInitialized = false;
    }

    private Selector.Listener mSelectorListener = new Selector.Listener() {
        @Override
        public void onTypeChanged(String result) {
            mListener.onResultChanged(result);
        }
    };

    void setEffort(boolean state) {
        mIsEffort = state;
    }

    void setRichIdea(boolean state) {
        mIsRichIdea = state;
    }

    void setOwnPace(boolean state) {
        mIsOwnPace = state;
    }

    void setKeepPromise(boolean state) {
        mIsKeepPromise = state;
    }

    void setEmotional(boolean state) {
        mIsEmotional = state;
    }

    void setHighExpectation(boolean state) {
        mIsHighExpectation = state;
    }

    private final StateGettable mStateGettable = new StateGettable() {
        @Override
        public boolean isEffort() {
            return mIsEffort;
        }

        @Override
        public boolean isRichIdea() {
            return mIsRichIdea;
        }

        @Override
        public boolean isOwnPace() {
            return mIsOwnPace;
        }

        @Override
        public boolean isKeepPromise() {
            return mIsKeepPromise;
        }

        @Override
        public boolean isEmotional() {
            return mIsEmotional;
        }

        @Override
        public boolean isHighExpectation() {
            return mIsHighExpectation;
        }
    };
}
