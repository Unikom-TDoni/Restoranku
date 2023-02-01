package edu.unikom.restoranku.module

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

class DateUtility {
    companion object {
        const val DATE_PATTERN_SERVER = "yyyy-MM-dd'T'HH:mm:ss"
        private const val DATE_PATTERN_DEFAULT = "dd MMMM yyyy"
        private const val TIME_PATTERN_DEFAULT = "HH:mm"

        fun convertStringToDate(string: String): Date? =
            SimpleDateFormat(DATE_PATTERN_DEFAULT, Locale.getDefault()).parse(string)

        fun convertDateToString(date: Date): String =
            SimpleDateFormat(DATE_PATTERN_DEFAULT, Locale.getDefault()).format(date)

        fun convertTimePickerToString(date: Date): String =
            SimpleDateFormat(TIME_PATTERN_DEFAULT, Locale.getDefault()).format(date)

        fun generateDatePickerDialog(
            context: Context,
            onDatePicked: (pickedDate: Date) -> Unit
        ): DatePickerDialog {
            val calendar = Calendar.getInstance()
            val dialogResult = DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    onDatePicked(calendar.time)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            dialogResult.datePicker.maxDate = Date().time
            return dialogResult
        }

        fun generateTimePickerDialog(
            context: Context,
            onTimePicked: (pickedDate: Date) -> Unit
        ): TimePickerDialog {
            val calendar = Calendar.getInstance()
            val dialogResult = TimePickerDialog(
                context,
                { _, hour, minute ->
                    calendar.set(Calendar.HOUR_OF_DAY, hour)
                    calendar.set(Calendar.MINUTE, minute)
                    onTimePicked(calendar.time)
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
            )
            return dialogResult
        }
    }
}