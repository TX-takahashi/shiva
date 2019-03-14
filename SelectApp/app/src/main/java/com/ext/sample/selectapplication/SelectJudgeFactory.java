package com.ext.sample.selectapplication;

import static com.google.common.base.Preconditions.checkArgument;

class SelectJudgeFactory {
    static SelectJudge create(StateGettable state){
        checkArgument(state != null, "StateGettable must not be null.");

        SelectJudge effortJudge = new EffortJudge(state);
        SelectJudge richIdeaJudge = new RichIdeaJudge(state);
        SelectJudge ownPaceJudge = new OwnPaceJudge(state);
        SelectJudge keepPromiseJudge = new KeepPromiseJudge(state);
        SelectJudge emotionalJudge = new EmotionalJudge(state);
        SelectJudge highExpectationJudge = new HighExpectationJudge(state);

        emotionalJudge.appendToTrueCase(highExpectationJudge);

        richIdeaJudge.appendToTrueCase(ownPaceJudge);
        richIdeaJudge.appendToFalseCase(highExpectationJudge);

        keepPromiseJudge.appendToFalseCase(emotionalJudge);

        effortJudge.appendToTrueCase(keepPromiseJudge);
        effortJudge.appendToFalseCase(richIdeaJudge);

        return effortJudge;
    }
}
