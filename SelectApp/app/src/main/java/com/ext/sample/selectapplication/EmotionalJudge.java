package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class EmotionalJudge extends SelectJudge {
    StateGettable mState;

    EmotionalJudge(StateGettable state) {
        checkArgument(state != null, "StateGettable must not be null.");
        mState = state;
    }

    @Override
    boolean checkCondition() {
        boolean ret = false;
        if (mState != null) {
            ret = mState.isEmotional();
        }
        return ret;
    }

    @Override
    Selector createFalseCase() {
        return new TypeBSelector();
    }
}
