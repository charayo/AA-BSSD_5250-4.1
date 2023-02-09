package com.example.aa_bssd_5250_41

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.marginTop
import androidx.fragment.app.commit
import com.example.aa_bssd_5250_32.NoteFragment
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    var noteCount = 0
    private var fid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val addButton = Button(this).apply {
            text = "+"
            id = View.generateViewId()
            setOnClickListener{
                supportFragmentManager.commit {

                    if(noteCount < 10){
                        add(fid, NoteFragment.newInstance(View.generateViewId(), "GRAY"),
                            null)
                        noteCount ++
                    }
                }
            }
        }
        val redAddButton = MaterialButton(this).apply {
            text = "+"
            id = View.generateViewId()
            setOnClickListener{
                supportFragmentManager.commit {

                    if(noteCount < 10){
                        add(fid, NoteFragment.newInstance(View.generateViewId(), "RED"),
                            null)
                        noteCount ++
                    }
                }
            }
        }
        val buttonsContainer = LinearLayoutCompat(this).apply {
            orientation = LinearLayoutCompat.HORIZONTAL
            id = View.generateViewId()
            redAddButton.apply {
                setBackgroundColor(Color.RED)

            }
            addView(addButton)
            addView(redAddButton)
        }
        val fragmentLinearLayout = LinearLayoutCompat(this).apply {
            id = View.generateViewId()
            fid = id
            orientation = LinearLayoutCompat.VERTICAL
            setBackgroundColor(Color.LTGRAY)
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            (layoutParams as RelativeLayout.LayoutParams).addRule(
                RelativeLayout.BELOW, buttonsContainer.id)
        }

        val relativeLayout = RelativeLayout(this).apply {
            setBackgroundColor(Color.WHITE)
            addView(buttonsContainer)
            addView(fragmentLinearLayout)

        }
        setContentView(relativeLayout)

    }
}