package com.gold.goldenyears;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Profile extends Fragment {

    private View mainView;
    private String user_name = "";
    private int user_age = 18;

    public Profile() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_profile, container, false);
        Button button = mainView.findViewById(R.id.applyButton);
        TextView textViewName = mainView.findViewById(R.id.profile_name_view);
        TextView textViewAge = mainView.findViewById(R.id.profile_age_view);
        TextView textViewSalary = mainView.findViewById(R.id.salary_view);
        RadioGroup radioGroup = mainView.findViewById(R.id.radioGroupSalary);
        int radioId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = mainView.findViewById(radioId);
        textViewName.setText(user_name);
        textViewAge.setText(Integer.toString(user_age));
        textViewSalary.setText(radioButton.getText());
        button.setOnClickListener(btnListener);
        return mainView;
    }


//    public void salary_checkButton(android.view.View v) {
//        int radioId = radioGroup.getCheckedRadioButtonId();
//
//        radioButton = mainView.findViewById(radioId);
//
////        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
////                Toast.LENGTH_SHORT).show();
//    }

    private View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View btnView) {
            RadioGroup radioGroup = mainView.findViewById(R.id.radioGroupSalary);
            TextView textViewName = mainView.findViewById(R.id.profile_name_view);
            TextView textViewAge = mainView.findViewById(R.id.profile_age_view);
            TextView textViewSalary = mainView.findViewById(R.id.salary_view);
            EditText textName = mainView.findViewById(R.id.text_input_user_name);
            EditText textAge = mainView.findViewById(R.id.text_input_user_age);
            int radioId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = mainView.findViewById(radioId);
            user_name = textName.getText().toString();
            if(user_name.length() > 30){
                user_name = "";
            }
            int user_age = 18;
            try {
                user_age = Integer.parseInt(textAge.getText().toString());
                if(user_age > 99 || user_age < 18){
                    throw new ArithmeticException("age input out of range");
                }
            }
            catch (Exception e){
                user_age = 18;
            }
            textViewName.setText(user_name);
            textViewAge.setText(Integer.toString(user_age));
            textViewSalary.setText(radioButton.getText());
        }
    };

}
