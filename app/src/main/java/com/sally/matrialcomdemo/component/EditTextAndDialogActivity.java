package com.sally.matrialcomdemo.component;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.dialogFragment.DialogFragment1;
import com.sally.matrialcomdemo.dialogFragment.DialogFragment2;

/**
 * Created by sally on 8/4/16.
 */
public class EditTextAndDialogActivity extends AppCompatActivity implements View.OnClickListener, DialogFragment2.LoginListener {

    private TextInputLayout mTextInputLayout;
    private EditText mEditText;
    private Button mDialog1;
    private Button mDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_dialog_activity);

        initView();
        initEvent();
    }

    private void initEvent() {
        mDialog1.setOnClickListener(this);
        mDialog2.setOnClickListener(this);

        mTextInputLayout.setHint("请输入姓名：");
        mEditText = mTextInputLayout.getEditText();
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 8 || s.length() < 6) {
                    mTextInputLayout.setErrorEnabled(true);
                    mTextInputLayout.setError("请将长度保持再6-8之间");
                } else {
                    mTextInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    private void initView() {
        mTextInputLayout = (TextInputLayout) findViewById(R.id.id_input_layout);
        mDialog1 = (Button) findViewById(R.id.id_show_dialog1);
        mDialog2 = (Button) findViewById(R.id.id_show_dialog2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_show_dialog1:
                DialogFragment1 dialogFragment1 = new DialogFragment1();
                dialogFragment1.show(getFragmentManager(), "dialog1");
                break;
            case R.id.id_show_dialog2:
                DialogFragment2 dialogFragment2 = new DialogFragment2();
                dialogFragment2.show(getFragmentManager(), "dialog2");
                break;
        }
    }

    @Override
    public void onLoginInputCompare(String userName, String password) {
        if(userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "名字密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, userName + ":" + password + "登陆了", Toast.LENGTH_SHORT).show();
    }
}
