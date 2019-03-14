package com.ext.sample.selectapplication;

abstract class SelectJudge {
    private SelectJudge mTrueCase;

    private SelectJudge mFalseCase;

    SelectJudge appendToTrueCase(SelectJudge judge) {
        mTrueCase = judge;
        return this;
    }

    SelectJudge appendToFalseCase(SelectJudge judge) {
        mFalseCase = judge;
        return this;
    }

    Selector create() {
        Selector ret;

        if (checkCondition()) {
            if (mTrueCase != null) {
                ret = mTrueCase.create();

            } else {
                ret = createTrueCase();
            }

        } else {
            if (mFalseCase != null) {
                ret = mFalseCase.create();

            } else {
                ret = createFalseCase();
            }
        }

        return ret;
    }

    abstract boolean checkCondition();

    Selector createTrueCase() {
        throw new UnsupportedOperationException("This class does not support createTrueCase");
    }

    Selector createFalseCase() {
        throw new UnsupportedOperationException("This class does not support createFalseCase");
    }

}
