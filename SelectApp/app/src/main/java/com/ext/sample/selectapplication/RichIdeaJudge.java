package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class RichIdeaJudge extends SelectJudge {
    StateGettable mState;

    RichIdeaJudge(StateGettable state) {
        checkArgument(state != null, "StateGettable must not be null.");
        mState = state;
    }

    @Override
    boolean checkCondition() {
        boolean ret = false;
        if (mState != null) {
            ret = mState.isRichIdea();
        }
        return ret;
    }

}
