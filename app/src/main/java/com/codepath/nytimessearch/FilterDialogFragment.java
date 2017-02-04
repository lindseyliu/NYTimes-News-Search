package com.codepath.nytimessearch;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilterDialogFragment extends DialogFragment implements DatePickerFragment.DatePickerDialogListener, DatePickerDialog.OnDateSetListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TITLE = "title";
    private static final String DATE = "date";

    // TODO: Rename and change types of parameters
    private String title;
    private String date;

    @BindView(R.id.btnPickDate)
    Button btnPickDate;

    public FilterDialogFragment() {
        // Required empty public constructor
    }

   public static FilterDialogFragment newInstance(String title) {
        FilterDialogFragment fragment = new FilterDialogFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        getDialog().setTitle("Filter");
        getDialog().getWindow().setTitle("Filter");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public interface FilterDialogListener {
        void onFinishFilterDialog(String date);
    }


    @OnClick(R.id.btnPickDate)
    void onPickDate(Button btn) {
        showDatePickerDialog(btn);
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setTargetFragment(FilterDialogFragment.this, 300);

        datePickerFragment.show(getFragmentManager(), "datePicker");
    }


    @Override public void onFinishDatePickerDialog(Calendar calendar) {
    }

    // handle the date selected
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        btnPickDate.setText(date);
    }

    @OnClick(R.id.submitFilter)
    void onSubmitFilter(Button btn) {
        FilterDialogListener listener = (FilterDialogListener) getActivity();
        listener.onFinishFilterDialog(date);
        dismiss();
    }
}
