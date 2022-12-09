package com.example.persistentbottomsheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout?> =
            BottomSheetBehavior.from(bottomsheet)

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> buttonShowBottomSheet.text = getString(R.string.close)
                    BottomSheetBehavior.STATE_COLLAPSED -> buttonShowBottomSheet.text = getString(R.string.open)
                    BottomSheetBehavior.STATE_DRAGGING -> {}
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    BottomSheetBehavior.STATE_SETTLING -> {}
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })

        buttonShowBottomSheet.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            } else {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
        }
    }
}