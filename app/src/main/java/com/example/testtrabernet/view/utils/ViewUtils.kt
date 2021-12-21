package com.example.testtrabernet.view.utils

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.showToast(text: String) =
    Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()