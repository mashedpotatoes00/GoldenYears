package com.gold.goldenyears;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EstimateContent extends Fragment {

    private View mainView;

    private View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View btnView) {
            EditText txtIncome = mainView.findViewById(R.id.txt_income);
            double income = Double.parseDouble(txtIncome.getText().toString());

            EditText txtExpend = mainView.findViewById(R.id.txt_expend);
            double expend = Double.parseDouble(txtExpend.getText().toString());

            EditText txtYears = mainView.findViewById(R.id.txt_years);
            double years = Double.parseDouble(txtYears.getText().toString());

            TextView estimate = mainView.findViewById(R.id.estimate_text);
            estimate.setText("$"+ Double.toString((income-expend)*years));
        }
    };

    public EstimateContent() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_estimate_content, container, false);
        Button button = mainView.findViewById(R.id.estimate_button);
        button.setOnClickListener(btnListener);
        return mainView;
    }

}
