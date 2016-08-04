package com.sally.matrialcomdemo.dialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.sally.matrialcomdemo.R;

/**
 * Created by sally on 8/4/16.
 */
public class DialogFragment2 extends DialogFragment {

    private EditText mEtName;
    private EditText mEtPassword;

    public interface LoginListener {
        void onLoginInputCompare(String userName, String password);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment2, null);
        mEtName = (EditText) view.findViewById(R.id.id_dialog_et_name);
        mEtPassword = (EditText) view.findViewById(R.id.id_dialog_et_password);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setNegativeButton("CANCEL", null)
                .setPositiveButton("LOGIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginListener listener = (LoginListener) getActivity();
                        listener.onLoginInputCompare(mEtName.getText().toString(), mEtPassword.getText().toString());
                    }
                });
        return builder.create();
    }

}
