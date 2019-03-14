package com.ext.sample.selectapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SelectController mSelectController;
    private TextView mTextView;
    private List<CompoundButton> mCompoundButtonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompoundButtonList = createUserItem();

        Button executeButton = findViewById(R.id.executeButton);
        executeButton.setOnClickListener(mOnClickListener);
        mTextView = findViewById(R.id.resultText);

        initController();
    }

    @Override
    public void onResume() {
        super.onResume();
        initialize();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSelectController.destroy();
    }

    private List<CompoundButton> createUserItem() {
        List<CompoundButton> compoundButtonList = new ArrayList<>();

        compoundButtonList.add((CompoundButton)findViewById(R.id.switch1));
        compoundButtonList.add((CompoundButton)findViewById(R.id.switch2));
        compoundButtonList.add((CompoundButton)findViewById(R.id.switch3));
        compoundButtonList.add((CompoundButton)findViewById(R.id.switch4));
        compoundButtonList.add((CompoundButton)findViewById(R.id.switch5));
        compoundButtonList.add((CompoundButton)findViewById(R.id.switch6));

        for (CompoundButton compoundButton : compoundButtonList) {
            compoundButton.setOnCheckedChangeListener(mOnCheckedChangeListener);
        }

        return compoundButtonList;
    }

    private void initialize() {
        for (CompoundButton button : mCompoundButtonList) {
            button.setChecked(false);
        }
    }

    private void initController() {
        mSelectController = new SelectController(mSelectControllerListener);
        mSelectController.init();
    }

    private final SelectController.Listener mSelectControllerListener
            = new SelectController.Listener() {
        @Override
        public void onResultChanged(String result) {
            if (!result.isEmpty()) {
                mTextView.setText(result);

            }
        }
    };

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener =
            new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switch1:
                    mSelectController.setEffort(isChecked);
                    break;
                case R.id.switch2:
                    mSelectController.setRichIdea(isChecked);
                    break;
                case R.id.switch3:
                    mSelectController.setOwnPace(isChecked);
                    break;
                case R.id.switch4:
                    mSelectController.setKeepPromise(isChecked);
                    break;
                case R.id.switch5:
                    mSelectController.setEmotional(isChecked);
                    break;
                case R.id.switch6:
                    mSelectController.setHighExpectation(isChecked);
                    break;
                default:
                    break;
            }
        }
    };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.executeButton:
                    mSelectController.executeCreate();
                    break;
                default:
                    break;
            }
        }
    };

}
