package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class KeepPromiseJudge extends SelectJudge {
    StateGettable mState;

    KeepPromiseJudge(StateGettable state) {
        checkArgument(state != null, "StateGettable must not be null.");
        mState = state;
    }

    @Override
    boolean checkCondition() {
        boolean ret = false;
        if (mState != null) {
            ret = mState.isKeepPromise();
        }
        return ret;
    }

    @Override
    Selector createTrueCase() {
        return new TypeASelector();
    }
}
