package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class HighExpectationJudge extends SelectJudge {
    StateGettable mState;

    HighExpectationJudge(StateGettable state) {
        checkArgument(state != null, "StateGettable must not be null.");
        mState = state;
    }


    @Override
    boolean checkCondition() {
        boolean ret = false;
        if (mState != null) {
            ret = mState.isHighExpectation();
        }
        return ret;
    }

    @Override
    Selector createTrueCase() {
        return new TypeDSelector();
    }

    @Override
    Selector createFalseCase() {
        return new TypeCSelector();
    }
}
