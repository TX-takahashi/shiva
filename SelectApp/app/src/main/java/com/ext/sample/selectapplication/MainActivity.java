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
    }

    @Override
    public void onResume() {
        super.onResume();
        initialize();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private List<CompoundButton> createUserItem() {
        List<CompoundButton> compoundButtonList = new ArrayList<>();

        compoundButtonList.add((CompoundButton)findViewById(R.id.toggleSwitch1));
        compoundButtonList.add((CompoundButton)findViewById(R.id.toggleSwitch2));
        compoundButtonList.add((CompoundButton)findViewById(R.id.toggleSwitch3));
        compoundButtonList.add((CompoundButton)findViewById(R.id.toggleSwitch4));
        compoundButtonList.add((CompoundButton)findViewById(R.id.toggleSwitch5));
        compoundButtonList.add((CompoundButton)findViewById(R.id.toggleSwitch6));

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

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener =
            (buttonView, isChecked) -> {
                switch (buttonView.getId()) {
                    case R.id.toggleSwitch1:
                        break;
                    case R.id.toggleSwitch2:
                        break;
                    case R.id.toggleSwitch3:
                        break;
                    case R.id.toggleSwitch4:
                        break;
                    case R.id.toggleSwitch5:
                        break;
                    case R.id.toggleSwitch6:
                        break;
                    default:
                        break;
                }
            };

    private View.OnClickListener mOnClickListener = view -> {
        switch (view.getId()) {
            case R.id.executeButton:
                break;
            default:
                break;
        }
    };

}
