package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class EffortJudge extends SelectJudge {
    StateGettable mState;

    EffortJudge(StateGettable state) {
        checkArgument(state != null, "StateGettable must not be null.");
        mState = state;
    }

    @Override
    boolean checkCondition() {
        boolean ret = false;
        if (mState != null) {
            ret = mState.isEffort();
        }
        return ret;
    }
}
