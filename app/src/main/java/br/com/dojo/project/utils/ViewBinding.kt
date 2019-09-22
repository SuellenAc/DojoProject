package br.com.dojo.project.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun visible(view: View, value: Boolean) {
    view.visibility = if (value) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

@BindingAdapter("present")
fun present(view: View, value: Boolean?) {
    value?.let {
        view.visibility = if (it) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

}