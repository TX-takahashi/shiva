package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class OwnPaceJudge extends SelectJudge {
    StateGettable mState;

    OwnPaceJudge(StateGettable state) {
        checkArgument(state != null, "StateGettable must not be null.");
        mState = state;
    }

    @Override
    boolean checkCondition() {
        boolean ret = false;
        if (mState != null) {
            ret = mState.isOwnPace();
        }
        return ret;
    }

    @Override
    Selector createTrueCase() {
        return new TypeFSelector();
    }

    @Override
    Selector createFalseCase() {
        return new TypeESelector();
    }
}
