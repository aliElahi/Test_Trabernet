package com.example.testtrabernet.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.testtrabernet.R
import com.example.testtrabernet.databinding.ActivityMainBinding
import com.example.testtrabernet.model.data.Status
import com.example.testtrabernet.model.utils.ResourceManager
import com.example.testtrabernet.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var bindig : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        viewModel.getUserStateLiveData().observe(this) {

            when (it.status) {
                Status.SUCCESS -> {
                    val message = ResourceManager.getString(
                        this.applicationContext,
                        R.string.consignment_is_selected
                    )

                    bindig.textView.text = message
                    setTextWrapContent()
                    showTextView()

                }
                else -> {
                    // do nothing
                }
            }

        }

    }

    private fun showTextView(){
        bindig.textView.isVisible = true
    }

    private fun setTextWrapContent(){

        val layoutParams = bindig.textView.layoutParams
        layoutParams.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
        bindig.textView.layoutParams = layoutParams
        bindig.textView.requestLayout()
    }

}