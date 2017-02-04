package com.codepath.nytimessearch;

/**
 * Created by lindseyl on 2/3/17.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

    private Calendar calendar;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Activity needs to implement this interface
        DatePickerDialog.OnDateSetListener listener =
                (DatePickerDialog.OnDateSetListener) getTargetFragment();

        // Create a new instance of TimePickerDialog and return it
        return new DatePickerDialog(getTargetFragment().getContext(), listener, year, month, day);
    }

    // Defines the listener interface
    public interface DatePickerDialogListener {
        void onFinishDatePickerDialog(Calendar calendar);
    }

    // Call this method to send the data back to the parent fragment
    public void sendBackResult() {
        // Notice the use of `getTargetFragment` which will be set when the dialog is displayed
        DatePickerDialogListener listener = (DatePickerDialogListener) getTargetFragment();
        listener.onFinishDatePickerDialog(calendar);
        dismiss();
    }


}
